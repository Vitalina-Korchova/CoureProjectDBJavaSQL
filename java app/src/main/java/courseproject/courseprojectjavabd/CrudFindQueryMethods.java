package courseproject.courseprojectjavabd;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.*;
import java.util.function.Function;

// Це клас з універсальними crud функціями і функція пошуку в таблицях
//також присутні функції універсальні показу даних в таблицях при запуску програми і функція, яка
//показує данні в полях при кліку на об'єкт(поле) в таблиці

public class CrudFindQueryMethods {

    private DBConnection dbConnection = new DBConnection();
    public CrudFindQueryMethods(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    //функції для зчитання даних з таблиць і показу їх в додатку
    //допоміжна функція для displayDataInTable
    public <T> void initializeTableColumns(List<TableColumn<T, ?>> tableColumns, List<String> nameVariablesClass) {
        if (tableColumns.size() != nameVariablesClass.size()) {
            throw new IllegalArgumentException("Кількість колонок та назв полів повинні збігатися!");
        }

        for (int i = 0; i < tableColumns.size(); i++) {
            tableColumns.get(i).setCellValueFactory(new PropertyValueFactory<>(nameVariablesClass.get(i)));
        }
    }

    public <T> void displayDataInTable(TableView<T> tableView, List<TableColumn<T, ?>> tableColumns, List<String> nameVariablesClass, ObservableList<T> dataList) {
        initializeTableColumns(tableColumns, nameVariablesClass);
        tableView.setItems(dataList);
    }


    public <T> ObservableList<T> getList(String query,     //зєднання з БД і застосування запиту Селект
                                         List<String> columnNames,
                                         Function<ResultSet, T> mapper) {
        ObservableList<T> list = FXCollections.observableArrayList();

        try { Connection connectionDB = dbConnection.getConnection();
            Statement statement = connectionDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                T item = mapper.apply(resultSet);
                list.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public void ClickAndDisplayDataInFieldsFromTable(TableView<?> table,  Runnable fillFormFields){
        table.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount()==1){
                fillFormFields.run();
            }
        });
    }


    public void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //функція для додавання даних
    public boolean addObject(Map<String, Object> fields, String query) {

        Connection connectionDB = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);

            int parameterIndex = 1;
            for (Object value : fields.values()) {
                preparedStatement.setObject(parameterIndex++, value);
            }

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Успіх", "Новий об'єкт було успішно додано!");
                return true;
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Новий об'єкт не було додано через помилку!");
                return false;
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //функція для оновлення даних
    public boolean updateObject(Map<String, Object> fields, String query, int id) {

        Connection connectionDB = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);

            int parameterIndex = 1;
            for (Object value : fields.values()) {
                preparedStatement.setObject(parameterIndex++, value);
            }
            preparedStatement.setInt(parameterIndex, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Успіх", "Об'єкт було успішно відредаговано!");
                return true;
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Об'єкт не було відредаговано через помилку!");
                return false;
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                connectionDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //функції для видалення даних
    public boolean showDeleteConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Підтвердження видалення");
        alert.setHeaderText(null);
        alert.setContentText("Ви дійсно хочете видалити?");

        ButtonType yesButton = new ButtonType("Так");
        ButtonType noButton = new ButtonType("Ні");

        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == yesButton;
    }

    public <T> void deleteObject(String query, TableView<T> table, Function<T, Integer> getIdFunction) {

        try {
            Connection connectionDB = dbConnection.getConnection();
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);

            T selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                int id = getIdFunction.apply(selectedItem);
                preparedStatement.setInt(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    showAlert(Alert.AlertType.INFORMATION, "Успіх", "Об'єкт був успішно видалений!");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Помилка", "Об'єкт не був видалений через помилку!");
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Попередження", "Жодного об'єкта не було обрано для видалення!");
            }

            connectionDB.close();
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000")) {
                // Якщо код помилки 23000, то це порушення зовнішнього ключа
                showAlert(Alert.AlertType.ERROR, "Помилка видалення", "Неможливо видалити об'єкт, оскільки він пов'язаний з іншими даними через зовнішній ключ!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            }
            //e.printStackTrace();
        }
    }

    //функція для пошуку даних по таблицям в додатку
    public <T> void FindInTable(TextField field, TableColumn<T, String> column, FilteredList<T> filteredList) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(item -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String cellValue = column.getCellData(item);

                if (cellValue != null) {
                    return cellValue.toLowerCase().contains(lowerCaseFilter);
                }
                return false;
            });
        });
    }

    //оновити список обєктів
    public <T> void updateList(String query, List<String> columnNamesDB, Function<ResultSet, T> mapper, ObservableList<T> dataList) {
        dataList.clear();
        dataList.addAll(getList(query, columnNamesDB, mapper));
    }

    //методи для запитів
    public ObservableList<Map<String, Object>> executeQuery(String query) {
        ObservableList<Map<String, Object>> resultList = FXCollections.observableArrayList();

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                resultList.add(row);
            }

            if (resultList.isEmpty()) {

                showAlert(Alert.AlertType.INFORMATION, "Повідомлення","Даних за запитом не було знайдено!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public void generateTableColumns(TableView<Map<String, Object>> tableView, ObservableList<Map<String, Object>> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        // Очищаємо наявні колонки
        tableView.getColumns().clear();

        // Беремо перший рядок, щоб отримати назви колонок
        Map<String, Object> firstRow = data.get(0);

        // Створюємо колонки динамічно на основі ключів (назв полів)
        for (String columnName : firstRow.keySet()) {
            TableColumn<Map<String, Object>, String> column = new TableColumn<>(columnName);

            column.setCellValueFactory(cellData -> {
                Map<String, Object> row = cellData.getValue();
                Object cellValue = row.get(columnName);
                return new SimpleStringProperty(cellValue != null ? cellValue.toString() : "");
            });

            tableView.getColumns().add(column);
        }
    }

    public Integer executeSingleValueQuery(String query) {
        Integer result = null;

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


}

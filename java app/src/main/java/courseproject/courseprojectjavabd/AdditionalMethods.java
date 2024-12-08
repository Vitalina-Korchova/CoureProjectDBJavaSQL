package courseproject.courseprojectjavabd;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalMethods {
    private DBConnection dbConnection = new DBConnection();

    public AdditionalMethods(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    //методи
    //функція, що буде отриувати ПІБ або назву з айді і відображати в таблиці в додатку
    //застосовується в blockPublication, blockOrder
    public String getNameFromID(int id, String tableName, String idColumnName, String nameColumnName) {
        String name = "";
        try (Connection connectionDB = dbConnection.getConnection();
             PreparedStatement statement = connectionDB.prepareStatement("SELECT " + idColumnName + ", " + nameColumnName + " FROM " + tableName + " WHERE " + idColumnName + " = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idValue = resultSet.getInt(idColumnName);
                String nameValue = resultSet.getString(nameColumnName);
                name = "ID: "+ idValue + "  " + nameValue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    //функція буде приймати поля з айді(зовнішні ключі) видаляти весь текст і повертати тік число
    public int cutAllGetOnlyID(String input){
        Pattern pattern = Pattern.compile("ID:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return 0;  // Повертає 0, якщо ID не знайдено
        }
    }

    public void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //перевірка полів  щоб не було однакових логінів, імен друкаронь, номерів замовлень, кодів видань
    public boolean CheckForIndividualFields(String alert, String query, String fieldText, TextField field) {
        try (Connection connectionDB = dbConnection.getConnection()) {
            try (PreparedStatement pstmtCheck = connectionDB.prepareStatement(query)) {
                pstmtCheck.setString(1, fieldText);
                try (ResultSet rs = pstmtCheck.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        showAlert(Alert.AlertType.ERROR, "Помилка", alert);
                        field.clear();
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //конект з БД для якихось перевірок
    public boolean checkDataInDB (String alert, String query, String fieldText) {
        try (Connection connectionDB = dbConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(query)) {
            preparedStatement.setString(1, fieldText.trim());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    showAlert(Alert.AlertType.ERROR, "Помилка", alert);
                    return false;
                }
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkExistenceAuthorPublication(String alert, String query, String publicationId, String authorId) {
        try (Connection connectionDB = dbConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(query)) {

            // Встановлюємо значення для обох параметрів запиту
            preparedStatement.setString(1, publicationId.trim());
            preparedStatement.setString(2, authorId.trim());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    showAlert(Alert.AlertType.ERROR, "Помилка", alert);
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    //використовується тільки для пошуку типу видань
    public boolean checkTypePublicationOrderInDB(String alert, String query, String fieldValue, ComboBox<String> field, String id) {
        try (Connection connectionDB = dbConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(query)) {

            // Використовуємо значення без обрізання для поля publication type
            preparedStatement.setString(1, fieldValue.trim());

            // Додаємо значення id для другого параметра
            preparedStatement.setString(2, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    showAlert(Alert.AlertType.ERROR, "Помилка", alert);
                    return false;
                }
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public TextField checkIsNumberValue(List<TextField> fields) {
        for (TextField field : fields) {
            String text = field.getText();
            if (text != null && !text.isEmpty()) {
                if (!text.matches("\\d+(\\.\\d+)?")) {
                    return field;
                }
            }
        }
        return null;
    }
}

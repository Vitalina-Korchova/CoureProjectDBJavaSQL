package courseproject.courseprojectjavabd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignInController {

    @FXML
    private Button buttonSignIn;

    @FXML
    private TextField loginSignIn;

    @FXML
    private PasswordField passwordSignIn;

    @FXML
    private AnchorPane signInPane;

    @FXML
    private Label labelForgotpswrdSignIn;

    private DBConnection dbConnection = new DBConnection();

    @FXML
    public void initialize() {
        buttonSignIn.setOnMouseClicked(mouseEvent -> {
            String login = loginSignIn.getText();
            String password = passwordSignIn.getText();
            try {
                CheckDataSignIn(login, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        ForgetPasswordFunc(loginSignIn);

    }

    private void CheckDataSignIn (String login, String password) throws SQLException {

        if (login == null || password == null || login.trim().isEmpty() || password.trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, заповніть всі поля!");
            return;
        }

        Connection connectionDB = dbConnection.getConnection();
        String query = "SELECT * FROM keys_data WHERE user_login = ? AND user_password = ?";

        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("main-window.fxml"));
                    Scene scene = new Scene(loader.load());

                    // передати данні в MainWindowController
                    MainWindowController mainWindowController = loader.getController();
                    mainWindowController.getDataFromForm(login, password);

                    Stage stage = new Stage();
                    scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    stage.setTitle("Система 'Видавництво'");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                    // закрити вікно SignInOnctroller
                    Stage currentStage = (Stage) buttonSignIn.getScene().getWindow();
                    currentStage.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                // Якщо немає збігу
                showAlert(Alert.AlertType.ERROR, "Помилка", "Невірний логін або пароль!");
                loginSignIn.clear();
                passwordSignIn.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connectionDB != null) {
                connectionDB.close();
            }
        }

    }

    private void ForgetPasswordFunc(TextField login){

        labelForgotpswrdSignIn.setOnMouseClicked(ev -> {
            if(login.getText().isEmpty()){
                showAlert(Alert.AlertType.ERROR, "Помилка", "Введіть логін для знаходження паролю!");
                return;
            }

            Connection connectionDB = dbConnection.getConnection();
            String query = "SELECT user_password FROM keys_data WHERE user_login = ?";

            try (PreparedStatement preparedStatement = connectionDB.prepareStatement(query)) {
                preparedStatement.setString(1, login.getText());
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String password = resultSet.getString("user_password");
                    showAlert(Alert.AlertType.INFORMATION, "Пароль знайдено", "Ваш пароль: " + password);
                } else {
                    showAlert(Alert.AlertType.WARNING, "Помилка", "Логін не знайдено!");
                }
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Помилка", "Не вдалося виконати запит до бази даних: " + e.getMessage());
            } finally {
                try {
                    if (connectionDB != null && !connectionDB.isClosed()) {
                        connectionDB.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

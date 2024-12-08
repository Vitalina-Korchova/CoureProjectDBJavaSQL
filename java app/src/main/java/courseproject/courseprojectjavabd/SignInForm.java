package courseproject.courseprojectjavabd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SignInForm extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignInForm.class.getResource("sign-in-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setTitle("Вхід");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}

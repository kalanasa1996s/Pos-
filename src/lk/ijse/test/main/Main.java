package lk.ijse.test.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent loginView = FXMLLoader.load(this.getClass().getResource("/lk/ijse/test/view/Login.fxml"));
        Scene loginViewScene = new Scene(loginView);

        primaryStage.setScene(loginViewScene);


        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}

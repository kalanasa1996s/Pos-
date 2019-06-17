package lk.ijse.test.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.test.common.NotificationController;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane signin;

    @FXML
    private JFXTextField userName_Txt;

    @FXML
    private JFXPasswordField password_txt;

    @FXML
    private JFXButton login_Btn;


    public void loginBtn_OnAction(ActionEvent event) throws IOException {


        String userName=userName_Txt.getText().trim();
        String password=password_txt.getText().trim();

        if (userName.equals("Admin")&& password.equals("1234")){






       Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/test/view/MainStage.fxml"));
        Scene scene=new Scene(parent);
        Stage stage= (Stage) this.signin.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Tripak.LK (V.1.0)");



        stage.setScene(scene);
        stage.show();

    }else{
            NotificationController.createError("Something went wrong.!", "Incorrect Username or Password");

        }
    }

    public void request(ActionEvent event) {
        password_txt.requestFocus();


    }
}

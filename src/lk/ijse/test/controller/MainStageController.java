package lk.ijse.test.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    private AnchorPane mainpanel;

    @FXML
    private AnchorPane mainmain;

    @FXML
    private Label txtDate;

    @FXML
    private Label txttime;



    public void onAction_Register(ActionEvent event) throws IOException {

        AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/test/view/CustomerPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);


    }

    public void onAction_Item(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/test/view/ItemPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);

    }


    public void onAction_Cart(ActionEvent event) throws IOException {
        AnchorPane anchorPane =FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/CartPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);


    }


    public void onAction_Rent(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/RentPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);


    }

    public void onAction_Payment(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/PaymentPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);

    }

    public void onAction_MainStage(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/dash.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);

    }


    public void Datetime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               txtDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txttime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Datetime();
    }

    public void onAction_Invoice(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/InvoiceForm.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);


    }

    public void OnAction_C_Button(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/CateringPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);



    }


    public void onAction_Orders(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/ijse/test/view/ItemPanel.fxml"));
        mainpanel.getChildren().clear();
        mainpanel.getChildren().add(anchorPane);
    }



}

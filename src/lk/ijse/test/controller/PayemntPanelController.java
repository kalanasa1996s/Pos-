package lk.ijse.test.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.test.bo.BOFactory;
import lk.ijse.test.bo.custom.PaymentBO;
import lk.ijse.test.bo.custom.impl.PaymentBOImpl;
import lk.ijse.test.dto.PaymentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PayemntPanelController implements Initializable {

    @FXML
    private AnchorPane item_panal;

    @FXML
    private JFXTextField txt_PId;

    @FXML
    private JFXTextField txt_PName;

    @FXML
    private JFXTextField txt_PPrice;

    @FXML
    private JFXTextField txt_PItemUnitPrice;

    @FXML
    private JFXTextField txt_PIQty;

    @FXML
    private JFXTextField txt_PDate;


    @FXML
    private TableView<PaymentDTO> tbl_Payment;

    static PaymentBO bo =(PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.PAYMENT);
    private static PaymentBO paymentBO =new PaymentBOImpl();

    public static boolean addPayment(PaymentDTO ref ) throws Exception {
        return bo.addItem(ref);

    }

    public static boolean updatePayment(PaymentDTO ref ) throws Exception {
        return bo.updateItem(ref);

    }

    public static boolean deletePayment(String id ) throws Exception {
        return bo.deleteItem(id);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }



    public void onActionPaymentId(ActionEvent event) {

        txt_PName.requestFocus();

    }

    public void onActionPaymentName(ActionEvent event) {
        txt_PPrice.requestFocus();
    }

    public void onActionPaymentPrice(ActionEvent event) {
        txt_PItemUnitPrice.requestFocus();
    }

    public void onActionPaymentUnitPrice(ActionEvent event) {
        txt_PIQty.requestFocus();
    }

    public void onActionPaymentQty(ActionEvent event) {
        txt_PDate.requestFocus();

    }

    public void onActionPaymentDate(ActionEvent event) {
        txt_PId.requestFocus();

    }







    public void onAction_P_Add(ActionEvent event) throws Exception {

        if (!txt_PId.getText().equals("")) {
            String pid = txt_PId.getText();
            String pname = txt_PName.getText();
            String pprice = txt_PPrice.getText();
            String punitprice = txt_PItemUnitPrice.getText();
            String pqty = txt_PIQty.getText();
            String pdate = txt_PDate.getText();


            PaymentDTO payModel = new PaymentDTO(pid, pname, pprice, punitprice,pqty,pdate);
            boolean addPayment = PayemntPanelController.addPayment(payModel);
            if (addPayment) {

                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
                a.showAndWait();
                getAllPayment();

            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Failed", ButtonType.OK);
                a.showAndWait();
            }
        }
    }


    public void onAction_P_Update(ActionEvent event) throws Exception {

        String pid = txt_PId.getText();
        String pname = txt_PName.getText();
        String pprice = txt_PPrice.getText();
        String punitprice = txt_PItemUnitPrice.getText();
        String pqty = txt_PIQty.getText();
        String pdate = txt_PDate.getText();


        PaymentDTO payModel = new PaymentDTO(pid, pname, pprice, punitprice,pqty,pdate);
        boolean updateCustomer = PayemntPanelController.updatePayment(payModel);
        if (updateCustomer) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();
            getAllPayment();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
            a.showAndWait();


        }


    }

    public void onAction_P_Delete(ActionEvent event) throws Exception {

        String paymentID = txt_PId.getText();
        boolean deletePayment = deletePayment(paymentID);
        if (deletePayment) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK);
            a.showAndWait();
            getAllPayment();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();

        }


    }

    private void getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentDTO> paymentList;
    try {
        paymentList = bo.getallPayment();
        ObservableList<PaymentDTO> payment = FXCollections.observableArrayList(paymentList);
        tbl_Payment.setItems(payment);
        tbl_Payment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("paymentID"));
        tbl_Payment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("paymentName"));
        tbl_Payment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("paymentPrice"));
        tbl_Payment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("paymentItemUnitPrice"));
        tbl_Payment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("paymentItemQty"));
        tbl_Payment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
    }catch (Exception e){

        System.out.println(e.getMessage());
    }



    }


    public void onMouseclicked_P_Table(MouseEvent mouseEvent) {

        PaymentDTO selectedPayment = tbl_Payment.getSelectionModel().getSelectedItem();

        txt_PId.setText(selectedPayment.getPaymentID());
        txt_PName.setText(selectedPayment.getPaymentName());
        txt_PPrice.setText(selectedPayment.getPaymentPrice());
        txt_PItemUnitPrice.setText(selectedPayment.getPaymentItemUnitPrice());
        txt_PIQty.setText(selectedPayment.getPaymentItemQty() );
        txt_PDate.setText(selectedPayment.getPaymentItemDate() );

    }

    public void onAction_P_Search(ActionEvent event) throws SQLException, ClassNotFoundException {

        PaymentDTO searchPayment = bo.searchPayment(txt_PId.getText());
        txt_PId.setText(searchPayment.getPaymentID());
        txt_PName.setText(searchPayment.getPaymentName());
        txt_PPrice.setText(searchPayment.getPaymentPrice());
        txt_PItemUnitPrice.setText(searchPayment.getPaymentItemUnitPrice());
        txt_PIQty.setText(searchPayment.getPaymentItemQty());
        txt_PDate.setText(searchPayment.getPaymentItemDate());


    }
}

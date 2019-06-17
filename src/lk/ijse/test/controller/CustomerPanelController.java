package lk.ijse.test.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.test.bo.BOFactory;
import lk.ijse.test.bo.custom.CustomerBO;
import lk.ijse.test.bo.custom.impl.CustomerBOImpl;
import lk.ijse.test.dto.CustomerDTO;
import lk.ijse.test.entity.Customer;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerPanelController implements Initializable {
    @FXML
    private JFXTextField txt_CustomerName;

    @FXML
    private JFXTextField txt_CustomerAddress;

    @FXML
    private JFXTextField txt_NIC;

    @FXML
    private JFXTextField txt_TP;

    @FXML
    private JFXTextField txt_CustomerID;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private JFXTextField txt_Search;



    static CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);

    private static CustomerBO customerBO=new CustomerBOImpl();

    public static boolean addCustomer(CustomerDTO ref) throws Exception {
        return bo.addCustomer(ref);
    }

    public static boolean updateCustomer(CustomerDTO ref) throws Exception {
        return bo.updateCustomer(ref);
    }

    public static boolean deleteCustomer(String id) throws Exception {
        return bo.deleteCustomer(id);
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            getAllCustomers();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void request(ActionEvent event) {
        txt_CustomerName.requestFocus();


    }

    public void customerNamerequest(ActionEvent event) {
        txt_CustomerName.requestFocus();
        txt_CustomerAddress.requestFocus();


    }


    public void customerAddress(ActionEvent event) {

        txt_CustomerAddress.requestFocus();
        txt_NIC.requestFocus();

    }

    public void customerNic(ActionEvent event) {
        txt_TP.requestFocus();

    }

    public void onAction_Reg(ActionEvent event) throws Exception {

        if (!txt_CustomerID.getText().equals("")) {
        String id = txt_CustomerID.getText();
        String name = txt_CustomerName.getText();
        String address = txt_CustomerAddress.getText();
        String nic = txt_NIC.getText();
        String tpc = txt_TP.getText();


         CustomerDTO cusModel = new CustomerDTO(id, name, address, nic,tpc);
        boolean addCustomer = CustomerPanelController.addCustomer(cusModel);
        if (addCustomer) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
            a.showAndWait();
            getAllCustomers();

        } else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Failed", ButtonType.OK);
            a.showAndWait();
        }
        }



    }

    public void onAction_Update(ActionEvent event) throws Exception {

        String id=txt_CustomerID.getText();
        String name=txt_CustomerName.getText();
        String address=txt_CustomerAddress.getText();
        String nic=txt_NIC.getText();
        String tpc = txt_TP.getText();

        CustomerDTO cusModel = new CustomerDTO(id, name, address, nic,tpc);
        boolean updateCustomer = CustomerPanelController.updateCustomer(cusModel);
        if (updateCustomer) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();
            getAllCustomers();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed", ButtonType.OK);
            a.showAndWait();


        }

    }

    public void onAction_Delete(ActionEvent event) throws Exception {
        String customerID = txt_CustomerID.getText();
        boolean deleteCustomer = deleteCustomer(customerID);
        if (deleteCustomer) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK);
            a.showAndWait();
            getAllCustomers();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed", ButtonType.OK);
            a.showAndWait();

        }


    }


    private void getAllCustomers() throws Exception {
        ArrayList<CustomerDTO> customerList;
        try {
            customerList = bo.getallCustomer();
            ObservableList<CustomerDTO> customers = FXCollections.observableArrayList(customerList);
            tblCustomer.setItems(customers);
            tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerID"));
            tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
            tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
            tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerNic"));
            tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("customerTp"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void onMousClicked_table(MouseEvent mouseEvent) {

        CustomerDTO selectedItem = tblCustomer.getSelectionModel().getSelectedItem();

        txt_CustomerID.setText(selectedItem.getCustomerID());
        txt_CustomerName.setText(selectedItem.getCustomerName());
        txt_CustomerAddress.setText(selectedItem.getCustomerAddress());
        txt_NIC.setText(selectedItem.getCustomerNic());
        txt_TP.setText(selectedItem.getCustomerTp() );
    }


    public void onAction_Search(ActionEvent event) throws SQLException, ClassNotFoundException {

        CustomerDTO searchCustomer =bo.searchCustomer(txt_Search.getText());
        txt_CustomerID.setText(searchCustomer.getCustomerID());
        txt_CustomerName.setText(searchCustomer.getCustomerName());
        txt_CustomerAddress.setText(searchCustomer.getCustomerAddress());
        txt_NIC.setText(searchCustomer.getCustomerNic());
        txt_TP.setText(searchCustomer.getCustomerTp());


    }
}


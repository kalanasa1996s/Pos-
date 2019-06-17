package lk.ijse.test.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.test.bo.BOFactory;
import lk.ijse.test.bo.custom.CateringBO;
import lk.ijse.test.dto.CateringDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CateringPanelController implements Initializable {

    @FXML
    private JFXTextField Catering_ID;

    @FXML
    private JFXTextField Catering_NoOfPlate;

    @FXML
    private JFXTextField Catering_Food_Catagory;

    @FXML
    private JFXTextField Catering_Search;

    @FXML
    private TableView<CateringDTO> tblCatering;


    static CateringBO bo = (CateringBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CATERING);


    public static boolean addCatering(CateringDTO ref) throws Exception {
        return bo.addCatering(ref);
    }

    public static boolean updateCatering(CateringDTO ref) throws Exception {
        return bo.updateCatering(ref);
    }

    public static boolean deleteCatering(String id) throws Exception {
        return bo.deleteCatering(id);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            getAllCatering();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onRequest_Ca_ID(ActionEvent event) {

        Catering_NoOfPlate.requestFocus();
    }

    public void onRequest_Ca_Plate(ActionEvent event) {

        Catering_Food_Catagory.requestFocus();
    }

    public void onRequest_Ca_Food(ActionEvent event) {
        Catering_ID.requestFocus();
    }

    public void onAction_C_Add(ActionEvent event) throws Exception {

        if (!Catering_ID.getText().equals("")) {
            String id = Catering_ID.getText();
            String plate = Catering_NoOfPlate.getText();
            String food = Catering_Food_Catagory.getText();



            CateringDTO cusModel = new CateringDTO(id, plate, food);
            boolean addCustomer = CateringPanelController.addCatering(cusModel);
            if (addCustomer) {

                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
                a.showAndWait();
//                getAllCustomers();

            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Failed", ButtonType.OK);
                a.showAndWait();
            }
        }



    }

    public void onAction_C_Update(ActionEvent event) throws Exception {



        String id = Catering_ID.getText();
        String plate = Catering_NoOfPlate.getText();
        String food = Catering_Food_Catagory.getText();

        CateringDTO cusModel = new CateringDTO(id, plate, food);
        boolean updateCatering = CateringPanelController.updateCatering(cusModel);
        if (updateCatering) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();
//            getAllCustomers();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed", ButtonType.OK);
            a.showAndWait();


        }



    }

    public void onAction_C_Delete(ActionEvent event) throws Exception {

        String CateringID = Catering_ID.getText();
        boolean deleteCustomer = deleteCatering(CateringID);
        if (deleteCustomer) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK);
            a.showAndWait();
//            getAllCustomers();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed", ButtonType.OK);
            a.showAndWait();

        }



    }



    private void getAllCatering(){
        ArrayList<CateringDTO> customerList;
        try {
            customerList = bo.getallCatering();
            ObservableList<CateringDTO> customers = FXCollections.observableArrayList(customerList);
            tblCatering.setItems(customers);
            tblCatering.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cateringID"));
            tblCatering.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("noOFPlate"));
            tblCatering.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("foodCategory"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public void onMousClicked_table_Catering(MouseEvent mouseEvent) {


        CateringDTO selectedItem = tblCatering.getSelectionModel().getSelectedItem();

        Catering_ID.setText(selectedItem.getCateringID());
        Catering_NoOfPlate.setText(selectedItem.getNoOFPlate());
        Catering_Food_Catagory.setText(selectedItem.getFoodCatagory());

    }


    public void onActionSearch_Catering(ActionEvent event) throws SQLException, ClassNotFoundException {


        CateringDTO searchCatering =bo.searchCatering(Catering_Search.getText());
        Catering_ID.setText(searchCatering.getCateringID());
        Catering_NoOfPlate.setText(searchCatering.getNoOFPlate());
        Catering_Food_Catagory.setText(searchCatering.getFoodCatagory());


    }
}





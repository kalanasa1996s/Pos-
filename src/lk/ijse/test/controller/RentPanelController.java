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
import javafx.scene.layout.AnchorPane;
import lk.ijse.test.bo.BOFactory;
import lk.ijse.test.bo.custom.RentBO;
import lk.ijse.test.bo.custom.impl.RentBOImpl;
import lk.ijse.test.dao.custom.RentDAO;
import lk.ijse.test.dto.RentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RentPanelController implements Initializable {


    @FXML
    private AnchorPane rent_i_panel;

    @FXML
    private JFXTextField txt_Rent_ID;

    @FXML
    private JFXTextField txt_Rent_Name;

    @FXML
    private JFXTextField txt_Rent_Date;

    @FXML
    private TableView<RentDTO> tbl_Rent;







    static RentBO bo = (RentBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.RENT);

    private static RentBO rentBO = new RentBOImpl();



    public static boolean addRent(RentDTO ref ) throws Exception {
        return bo.addItem(ref);
    }

    public static boolean updateRent(RentDTO ref ) throws Exception {
        return bo.updateItem(ref);
    }

    public static boolean deleteRent(String id ) throws Exception {
        return bo.deleteItem(id);
    }


    public static RentDTO searchRent(String id) throws SQLException, ClassNotFoundException {
        return bo.searchRent(id);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            getAllRent();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onActionRentID(ActionEvent event) {

        txt_Rent_Name.requestFocus();
    }

    public void onActionRentName(ActionEvent event) {
        txt_Rent_Date.requestFocus();

    }

    public void onActionRentDate(ActionEvent event) {
        txt_Rent_ID.requestFocus();
    }


    public void onAction_R_Add(ActionEvent event) throws Exception {

        if (!txt_Rent_ID.getText().equals("")) {
            String rid = txt_Rent_ID.getText();
            String rname = txt_Rent_Name.getText();
            String rdate = txt_Rent_Date.getText();


            RentDTO  rentModel =new RentDTO(rid,rname,rdate);
            boolean addRent = RentPanelController.addRent(rentModel);
            if (addRent){

                Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Added ",ButtonType.OK);
                a.showAndWait();
                getAllRent();


            }else {
                Alert a =new Alert(Alert.AlertType.CONFIRMATION,"Failed",ButtonType.OK);
                a.showAndWait();


            }
        }






    }

    public void onAction_R_Update(ActionEvent event) throws Exception {

        String rid = txt_Rent_ID.getText();
        String rname = txt_Rent_Name.getText();
        String rdate = txt_Rent_Date.getText();


        RentDTO rentModel = new RentDTO(rid,rname,rdate);
        boolean updateRent = RentPanelController.updateRent(rentModel);
        if (updateRent){

            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Update",ButtonType.OK);
            a.showAndWait();
            getAllRent();

        }else {

            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Failed",ButtonType.OK);
            a.showAndWait();

        }

    }


    public void onAction_R_Remove(ActionEvent event) throws Exception {

        String rentID = txt_Rent_ID.getText();
        boolean deleteRent = deleteRent(rentID);
        if (deleteRent){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Removed",ButtonType.OK);
            a.showAndWait();
            getAllRent();


        }else {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Failed",ButtonType.OK);
            a.showAndWait();
        }



    }


    private void  getAllRent(){

        ArrayList<RentDTO> rentList;
        try {
            rentList =bo.getallRent();
            ObservableList<RentDTO> rent = FXCollections.observableArrayList(rentList);
            tbl_Rent.setItems(rent);
            tbl_Rent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("rentID"));
            tbl_Rent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("rentName"));
            tbl_Rent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void onMouseClicked_tbl_Rent(MouseEvent mouseEvent) {

        RentDTO selectedItem = tbl_Rent.getSelectionModel().getSelectedItem();

        txt_Rent_ID.setText(selectedItem.getRentID());
        txt_Rent_Name.setText(selectedItem.getRentName());
        txt_Rent_Date.setText(selectedItem.getRentDate());




    }

    public void onAction_R_Search(ActionEvent event) throws SQLException, ClassNotFoundException {

        RentDTO searchRent=bo.searchRent(txt_Rent_ID.getText());
        txt_Rent_ID.setText(searchRent.getRentID());
        txt_Rent_Name.setText(searchRent.getRentName());
        txt_Rent_Date.setText(searchRent.getRentDate());


    }



}






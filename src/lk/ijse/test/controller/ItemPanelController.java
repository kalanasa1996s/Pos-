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
import lk.ijse.test.bo.custom.ItemBO;
import lk.ijse.test.dto.CustomerDTO;
import lk.ijse.test.dto.ItemDTO;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemPanelController implements Initializable {


    @FXML
    private AnchorPane item_panal;

    @FXML
    private JFXTextField txt_Item_name;

    @FXML
    private JFXTextField txt_Item_coad;

    @FXML
    private JFXTextField txt_Item_UnitPrice;


    @FXML
    private JFXTextField txt_Item_Qty;

    @FXML
    private JFXTextField txt_Item_Exp;

    @FXML
    private JFXTextField txt_itemId;

    @FXML
    private TableView<ItemDTO> blItem;

    static ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.ITEM);

    public static boolean addItem(ItemDTO item) throws Exception {
        return bo.addItem(item);
    }

    public static boolean updateItem(ItemDTO item) throws Exception {
        return bo.updateItem(item);

    }

    public static boolean deleteItem(String code) throws Exception {
        return bo.deleteItem(code);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllItems();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void itemId_Request(ActionEvent event) {

        txt_Item_name.requestFocus();


    }

    public void itemNamere_quest(ActionEvent event) {

        txt_Item_coad.requestFocus();

    }

    public void itemCoad_quest(ActionEvent event) {


        txt_Item_UnitPrice.requestFocus();

    }

    public void itemUnitPrice_quest(ActionEvent event) {
        txt_Item_Qty.requestFocus();

    }

    public void itemqty_quest(ActionEvent event) {

        txt_Item_Exp.requestFocus();
    }


    public void expD_quest(ActionEvent event) {
        txt_itemId.requestFocus();
    }


    public void onAction_Iadd(ActionEvent event) throws Exception {

        String itemID = txt_itemId.getText();
        String itemName = txt_Item_name.getText();
        String itemCoad = txt_Item_coad.getText();
        String itemUnitPrice = txt_Item_UnitPrice.getText();
        String itemQty = txt_Item_Qty.getText();
        String itemExDate = txt_Item_Exp.getText();

        ItemDTO ItemModel = new ItemDTO(itemID,itemName,itemCoad,itemUnitPrice,itemQty,itemExDate);



        boolean addItem=ItemPanelController.addItem(ItemModel);
        if (addItem){
            Alert a =new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK);
            a.showAndWait();
            getAllItems();
        }else {
            Alert a =new Alert(Alert.AlertType.CONFIRMATION,"Failed",ButtonType.OK);
            a.showAndWait();

        }


    }


    public void onAction_Update(ActionEvent event) throws Exception {

        String itemID=txt_itemId.getText();
        String itemName=txt_Item_name.getText();
        String itemCode=txt_Item_coad.getText();
        String itemUnitPrice=txt_Item_UnitPrice.getText();
        String itemQty = txt_Item_Qty.getText();
        String itemEx = txt_Item_Exp.getText();

        ItemDTO itemModel = new ItemDTO(itemID, itemName, itemCode, itemUnitPrice,itemQty,itemEx);
        boolean updateItem = ItemPanelController.updateItem(itemModel);
        if (updateItem) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();
            getAllItems();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
            a.showAndWait();


        }


    }

    public void onAction_Delete(ActionEvent event) throws Exception {


        String customerID = txt_itemId.getText();
        boolean deleteItem = deleteItem(customerID);
        if (deleteItem) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK);
            a.showAndWait();
            getAllItems();


        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();

        }




    }

    private void getAllItems() throws Exception {
        ArrayList<ItemDTO> customerList;
        try {
            customerList = bo. getAllItem();
            ObservableList<ItemDTO> customers = FXCollections.observableArrayList(customerList);
            blItem.setItems(customers);
            blItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            blItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
            blItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            blItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("itemUnitPrice"));
            blItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("itemQty"));
            blItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onMouseClicked_Itable(MouseEvent mouseEvent) {
        ItemDTO selectedItem = blItem.getSelectionModel().getSelectedItem();

        txt_itemId.setText(selectedItem.getId());
        txt_Item_name.setText(selectedItem. getItemName());
        txt_Item_coad.setText(selectedItem. getItemCode());
        txt_Item_UnitPrice.setText(selectedItem.getItemUnitPrice());
        txt_Item_Qty.setText(selectedItem.getItemQty() );
        txt_Item_Exp.setText(selectedItem.getExpiryDate() );
    }
}
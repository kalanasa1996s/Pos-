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
import lk.ijse.test.bo.custom.CartBO;
import lk.ijse.test.bo.custom.impl.CartBOImpl;
import lk.ijse.test.dto.CartDTO;
import lk.ijse.test.entity.Cart;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CartPanelConntroller implements Initializable {
    @FXML
    private AnchorPane cart_panal;

    @FXML
    private JFXTextField txt_cartID;

    @FXML
    private JFXTextField txt_cartName;

    @FXML
    private JFXTextField txt_cartCoad;

    @FXML
    private JFXTextField txt_custID;

    @FXML
    private JFXTextField txt_cartDate;


    @FXML
    private TableView<CartDTO> tblCart;


//
//    static CartBO bo =(CartBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CART);
    static CartBO bo=(CartBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CART);

    private static CartBO cartBO=new CartBOImpl();

    public static boolean addCart(CartDTO ref) throws Exception {
        return bo.addCart(ref);
    }


    public static boolean updateCart( CartDTO ref) throws Exception {
        return bo.updateCart(ref);
    }

    public static boolean deleteCart( String id) throws Exception {
        return bo.deleteCart(id);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getAllCart();

    }


    public void onAction_CartId(ActionEvent event) {

        txt_cartName.requestFocus();
    }


    public void onAction_CartName(ActionEvent event) {

        txt_cartCoad.requestFocus();
    }


    public void onAction_CartCode(ActionEvent event) {
        txt_custID.requestFocus();

    }

    public void onActionCustId(ActionEvent event) {
        txt_cartDate.requestFocus();
    }

    public void onAction_Cartdate(ActionEvent event) {

        txt_custID.requestFocus();
    }







    public void onActionCAdd(ActionEvent event) throws Exception {
        if (txt_cartID.getText().equals("")) {
            String id = txt_cartID.getText();
            String name = txt_cartName.getText();
            String cartCode = txt_cartCoad.getText();
            String cartId = txt_cartID.getText();
            String cartDate = txt_cartDate.getText();


            CartDTO cartModel = new CartDTO(id, name, cartCode, cartId,cartDate);
            boolean addCart = CartPanelConntroller.addCart(cartModel);
            if (addCart) {

                Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
                a.showAndWait();
                getAllCart();

            } else {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Failed", ButtonType.OK);
                a.showAndWait();
            }
        }

    }


    public void onActionCUpdate(ActionEvent event) throws Exception {


        String id = txt_cartID.getText();
        String name = txt_cartName.getText();
        String cartCode = txt_cartCoad.getText();
        String cartId = txt_cartID.getText();
        String cartDate = txt_cartDate.getText();


        CartDTO cartModel = new CartDTO(id, name, cartCode, cartId,cartDate);
        boolean updateCart = CartPanelConntroller.updateCart(cartModel) ;
        if (updateCart) {

            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();
            getAllCart();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK);
            a.showAndWait();


        }



    }

    public void onActionCDelete(ActionEvent event) throws Exception {

        String cartId = txt_cartID.getText();
        boolean deleteCart = deleteCart(cartId);
        if (deleteCart) {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Deleted", ButtonType.OK);
            a.showAndWait();
            getAllCart();

        } else {
            Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Updated", ButtonType.OK);
            a.showAndWait();

        }


    }

    private void getAllCart() {

        ArrayList<CartDTO> cartList;
        try {
            cartList = bo.getallCart();
            ObservableList<CartDTO> cart = FXCollections.observableArrayList(cartList);
            tblCart.setItems(cart);
            tblCart.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cartID"));
            tblCart.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cartName"));
            tblCart.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cartCode"));
            tblCart.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("custId"));
            tblCart.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cartDate"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public void onMousClicked_Ctable(MouseEvent mouseEvent) {

        CartDTO selectedItem = tblCart.getSelectionModel().getSelectedItem();

        txt_cartID.setText(selectedItem.getCartID());
        txt_cartName.setText(selectedItem.getCartName());
        txt_cartCoad.setText(selectedItem.getCartCoad());
        txt_custID.setText(selectedItem.getCartID());
        txt_cartDate.setText(selectedItem.getCartDate() );


    }

    public void onActionCSearch(ActionEvent event) throws SQLException, ClassNotFoundException {

        CartDTO searchCart = bo.searchCart(txt_cartID.getText());
        txt_cartID.setText(searchCart.getCartID());
        txt_cartName.setText(searchCart.getCartName());
        txt_cartCoad.setText(searchCart.getCartCoad());
        txt_custID.setText(searchCart.getCustID());
        txt_cartDate.setText(searchCart.getCartDate());



    }
}


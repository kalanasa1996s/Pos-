package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;
import lk.ijse.test.dao.custom.CartDAO;
import lk.ijse.test.entity.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAOImpl implements CartDAO {
    @Override
    public boolean add(Cart entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Cart values(?,?,?,?,?)",entity.getCartID(),entity.getCartName(),entity.getCartCoad(),entity.getCustID(),entity.getCartDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Cart where CartID=?",id);
    }

    @Override
    public boolean update(Cart entity) throws Exception {
        return CrudUtil.executeUpdate("update Cart set CartName=?,  CARTCoad=?, CustID=?,CartDate=? where CartID=? ", entity.getCartName(),entity.getCartCoad(),entity.getCustID(),entity.getCartDate(),entity.getCartID());
    }

    @Override
    public Cart search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Cart where CartID=?",code);
        if (rst.next()){
            return  new Cart(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );


        }

        return null;
    }

    @Override
    public ArrayList<Cart> getall() throws SQLException, ClassNotFoundException {
        ArrayList<Cart>  Cart =new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from Cart");
        while (rst.next()){


            Cart.add(new Cart(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));


        }
        return Cart;
    }

//    @Override
//    public String getLastCart() throws SQLException, ClassNotFoundException {
//        return null;
//    }

}

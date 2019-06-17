package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.CartDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CartBO extends SuperBO {

    public boolean addCart(CartDTO ref) throws Exception;

    public boolean updateCart(CartDTO ref) throws Exception;

    public boolean deleteCart(String id) throws Exception;


    public CartDTO searchCart(String code) throws ClassNotFoundException, SQLException;

    public ArrayList<CartDTO> getallCart() throws SQLException, ClassNotFoundException;

}

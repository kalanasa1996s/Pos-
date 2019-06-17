package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.CartBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.CartDAO;
import lk.ijse.test.dto.CartDTO;
import lk.ijse.test.entity.Cart;

import java.sql.SQLException;
import java.util.ArrayList;

public class CartBOImpl implements CartBO {

    CartDAO dao = (CartDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CART);

    @Override
    public boolean addCart(CartDTO ref) throws Exception {
        return dao.add(new Cart(ref.getCartID(),ref.getCartName(),ref.getCartCoad(),ref.getCustID(),ref.getCartDate()));
    }

    @Override
    public boolean updateCart(CartDTO ref) throws Exception {
        return dao.update(new Cart(ref.getCartID(),ref.getCartName(),ref.getCartCoad(),ref.getCustID(),ref.getCartDate()));
    }

    @Override
    public boolean deleteCart(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CartDTO searchCart(String code) throws ClassNotFoundException, SQLException {
        Cart search =dao.search(code);
        return new CartDTO(search.getCartID(),search.getCartName(),search.getCartCoad(),search.getCustID(),search.getCartDate());
    }

    @Override
    public ArrayList<CartDTO> getallCart() throws SQLException, ClassNotFoundException {
        ArrayList<Cart>all=dao.getall();
        ArrayList<CartDTO> allCart=new ArrayList<>();
        for (Cart ser:all){
            allCart.add(new CartDTO(
                    ser.getCartID(),
                    ser.getCartName(),
                    ser.getCartCoad(),
                    ser.getCustID(),
                    ser.getCartDate()
            ));

        }


        return allCart;
    }
}

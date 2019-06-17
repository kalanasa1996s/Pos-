package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    public boolean addItem(ItemDTO item) throws Exception;

    public boolean updateItem(ItemDTO item) throws Exception;

    public boolean deleteItem(String code) throws Exception;

//    public ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException;


    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

}

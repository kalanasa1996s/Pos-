package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.ItemBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.ItemDAO;
import lk.ijse.test.dto.ItemDTO;
import lk.ijse.test.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    static ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        return dao.add(new Item(item.getId(),item.getItemName(),item.getItemCode(),item.getItemUnitPrice(),item.getItemQty(),item.getExpiryDate()));
    }

    @Override
    public boolean updateItem(ItemDTO item) throws Exception {
        return dao.update(new Item(item.getId(),item.getItemName(),item.getItemCode(),item.getItemUnitPrice(),item.getItemQty(),item.getExpiryDate()));
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return dao.delete(code);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {


        ArrayList<Item> all=dao.getall();
        ArrayList<ItemDTO>allitem=new ArrayList<>();
        for (Item ser:all){
            allitem.add(new ItemDTO(
                    ser.getId(),
                    ser.getItemName(),
                    ser.getItemCode(),
                    ser.getItemUnitPrice(),
                    ser.getItemQty(),
                    ser.getExpiryDate()
            ));

        }


        return allitem;
    }
}

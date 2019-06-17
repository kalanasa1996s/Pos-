package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;
import lk.ijse.test.dao.custom.ItemDAO;
import lk.ijse.test.entity.Customer;
import lk.ijse.test.entity.Item;
import org.controlsfx.control.PropertySheet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws Exception {
        return CrudUtil.executeUpdate("insert into Item values(?,?,?,?,?,?)",item.getId(),item.getItemName(),item.getItemCode(),item.getItemUnitPrice(),item.getItemQty(),item.getExpiryDate());
    }


    @Override
    public boolean delete(String code) throws Exception {
        return CrudUtil.executeUpdate("delete from Item where  ItemID=?",code);
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.executeUpdate("Update Item Set ItemName=?, ItemCode=?,UnitPrice=?,ItemQTY=?,ItemExDate=? where ItemID=?", item.getItemName(),item.getItemCode(),item.getItemUnitPrice(),item.getItemQty(),item.getExpiryDate(),item.getId());
    }

    @Override
    public Item search(String code) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Item> getall() throws SQLException, ClassNotFoundException {
        ArrayList<Item> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from item");
        while (rst.next()){
            company.add(new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return company;
    }
}

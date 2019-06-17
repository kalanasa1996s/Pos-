package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.RentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentBO extends SuperBO {

    public boolean addItem( RentDTO item) throws Exception;

    public boolean updateItem(RentDTO item) throws Exception;

    public boolean deleteItem(String id) throws Exception;

    public RentDTO searchRent(String code) throws ClassNotFoundException, SQLException;

    public ArrayList<RentDTO> getallRent() throws SQLException, ClassNotFoundException;

}

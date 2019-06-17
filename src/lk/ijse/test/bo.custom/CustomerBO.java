package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO ref) throws Exception;

    public boolean updateCustomer(CustomerDTO ref) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public CustomerDTO searchCustomer(String code) throws ClassNotFoundException, SQLException;

    public ArrayList<CustomerDTO> getallCustomer() throws SQLException, ClassNotFoundException;


}



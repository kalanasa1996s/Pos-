package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.CustomerBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.CustomerDAO;
import lk.ijse.test.dto.CustomerDTO;
import lk.ijse.test.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {


    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO ref) throws Exception {
       return dao.add(new Customer(ref.getCustomerID(), ref.getCustomerName(), ref.getCustomerAddress(), ref.getCustomerNic(),ref.getCustomerTp()));

    }

    @Override
    public boolean updateCustomer(CustomerDTO ref) throws Exception {
       return dao.update(new Customer(ref.getCustomerID(), ref.getCustomerName(), ref.getCustomerAddress(), ref.getCustomerNic(),ref.getCustomerTp()));

    }


    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(String code) throws ClassNotFoundException, SQLException {
        Customer search = dao.search(code);
        return new CustomerDTO(search.getCustomerID(), search.getCustomerName(), search.getCustomerAddress(),search.getCustomerNic(),search.getCustomerTp());
    }



    @Override
    public ArrayList<CustomerDTO> getallCustomer() throws SQLException, ClassNotFoundException {

         ArrayList<Customer> all=dao.getall();
        ArrayList<CustomerDTO> allcus=new ArrayList<>();
         for(Customer ser:all){
        allcus.add(new CustomerDTO(
                ser.getCustomerID(),
                ser.getCustomerName(),
                ser.getCustomerAddress(),
                ser.getCustomerNic(),
                ser.getCustomerTp()
        ));
}
        return allcus;
    }

}

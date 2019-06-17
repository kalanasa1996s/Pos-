package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;

import lk.ijse.test.dao.custom.CustomerDAO;
import lk.ijse.test.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public boolean add(Customer ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Customer values(?,?,?,?,?)", ref.getCustomerID(), ref.getCustomerName(), ref.getCustomerAddress(), ref.getCustomerNic(),ref.getCustomerTp());
    }

    @Override
    public boolean update(Customer ref) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("update Customer set custname=?,custaddress=?,custnic=?,custtp=? where custid=?", ref.getCustomerName(), ref.getCustomerAddress(), ref.getCustomerNic(), ref.getCustomerTp(),ref.getCustomerID());
    }

    @Override
    public Customer search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Customer where CustID=?", code);
        if (rst.next()){
            return new Customer(
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
    public ArrayList<Customer> getall() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from customer");
        while (rst.next()){
            company.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return company;
    }



    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("delete from Customer where custid=?", id);
    }





}

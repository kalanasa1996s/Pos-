package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;
import lk.ijse.test.dao.custom.PaymentDAO;
import lk.ijse.test.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {



    @Override
    public boolean add(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Payment values (?,?,?,?,?,?)",entity.getPaymentID(),entity.getPaymentName(),entity.getPaymentPrice(),entity.getPaymentItemUnitPrice(),entity.getPaymentItemQty(),entity.getPaymentItemDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Payment where PaymentID=?",id);
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("update Payment set  PaymentName=?,PaymentPrice=?,PaymentItemUnitPrice=?,PaymentItemQty=?,PaymentDate=? where PaymentID=? ", entity.getPaymentName(),entity.getPaymentPrice(),entity.getPaymentItemUnitPrice(),entity.getPaymentItemQty(),entity.getPaymentItemQty(),entity.getPaymentItemDate(),entity.getPaymentID());
    }

    @Override
    public Payment search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Payment where PaymentID=?", code);
        if (rst.next()){
            return new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Payment> getall() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from customer");
        while (rst.next()){
            company.add(new Payment(
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

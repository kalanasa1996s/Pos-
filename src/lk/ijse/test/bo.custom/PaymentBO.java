package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {

    public boolean addItem(PaymentDTO item) throws Exception;

    public boolean updateItem(PaymentDTO item) throws Exception;

    public boolean deleteItem(String id) throws Exception;

    public PaymentDTO searchPayment (String code) throws ClassNotFoundException, SQLException;

    public ArrayList<PaymentDTO> getallPayment() throws SQLException, ClassNotFoundException;

}

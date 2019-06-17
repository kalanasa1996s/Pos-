package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.PaymentBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.PaymentDAO;
import lk.ijse.test.dto.PaymentDTO;
import lk.ijse.test.entity.Customer;
import lk.ijse.test.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl  implements PaymentBO {

    PaymentDAO dao =(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public boolean addItem(PaymentDTO item) throws Exception {
        return dao.add(new Payment(item.getPaymentID(),item.getPaymentName(),item.getPaymentPrice(),item.getPaymentItemUnitPrice(),item.getPaymentItemQty(),item.getPaymentItemDate()));
    }

    @Override
    public boolean updateItem(PaymentDTO item) throws Exception {
        return dao.update(new Payment(item.getPaymentID(),item.getPaymentName(),item.getPaymentPrice(),item.getPaymentItemUnitPrice(),item.getPaymentItemQty(),item.getPaymentItemDate()));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public PaymentDTO searchPayment(String code) throws ClassNotFoundException, SQLException {
        Payment search =dao.search(code);
        return new PaymentDTO(search.getPaymentID(),search.getPaymentName(),search.getPaymentPrice(),search.getPaymentItemUnitPrice(),search.getPaymentItemQty(),search.getPaymentItemDate());
    }

    @Override
    public ArrayList<PaymentDTO> getallPayment() throws SQLException, ClassNotFoundException {
         ArrayList<Payment> all =dao.getall();
         ArrayList<PaymentDTO> allpayment=new ArrayList<>();
         for (Payment ser:all){
             allpayment.add(new PaymentDTO(
                     ser.getPaymentID(),
                     ser.getPaymentName(),
                     ser.getPaymentPrice(),
                     ser.getPaymentItemUnitPrice(),
                     ser.getPaymentItemQty(),
                     ser.getPaymentItemDate()


             ));
         }

        return allpayment;
    }
}



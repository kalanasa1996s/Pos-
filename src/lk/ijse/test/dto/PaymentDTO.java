package lk.ijse.test.dto;

public class PaymentDTO {

    private String paymentID;
    private String paymentName;
    private String paymentPrice;
    private String paymentItemUnitPrice;
    private String paymentItemQty;
    private String paymentItemDate;

    public PaymentDTO(){


    }

    public PaymentDTO(String paymentID, String paymentName, String paymentPrice, String paymentItemUnitPrice, String paymentItemQty, String paymentItemDate) {
        this.paymentID = paymentID;
        this.paymentName = paymentName;
        this.paymentPrice = paymentPrice;
        this.paymentItemUnitPrice = paymentItemUnitPrice;
        this.paymentItemQty = paymentItemQty;
        this.paymentItemDate = paymentItemDate;
    }


    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(String paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public String getPaymentItemUnitPrice() {
        return paymentItemUnitPrice;
    }

    public void setPaymentItemUnitPrice(String paymentItemUnitPrice) {
        this.paymentItemUnitPrice = paymentItemUnitPrice;
    }

    public String getPaymentItemQty() {
        return paymentItemQty;
    }

    public void setPaymentItemQty(String paymentItemQty) {
        this.paymentItemQty = paymentItemQty;
    }

    public String getPaymentItemDate() {
        return paymentItemDate;
    }

    public void setPaymentItemDate(String paymentItemDate) {
        this.paymentItemDate = paymentItemDate;
    }
}

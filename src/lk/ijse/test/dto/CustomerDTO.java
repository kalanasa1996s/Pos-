package lk.ijse.test.dto;

public class CustomerDTO {

    private String customerID;
    private String customerName;
    private String customerAddress;
    private String customerNic;
    private String customerTp;


    public CustomerDTO() {

    }

    public CustomerDTO(String customerID, String customerName, String customerAddress, String customerNic, String customerTp) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNic = customerNic;
        this.customerTp = customerTp;
    }


    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public String getCustomerTp() {
        return customerTp;
    }

    public void setCustomerTp(String customerTp) {
        this.customerTp = customerTp;
    }
}

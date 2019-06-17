package lk.ijse.test.entity;

public class Rent {

private String rentID;
private String rentName;
private String rentDate;


    public Rent(String rentID, String rentName, String rentDate) {
        this.rentID = rentID;
        this.rentName = rentName;
        this.rentDate = rentDate;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }
}

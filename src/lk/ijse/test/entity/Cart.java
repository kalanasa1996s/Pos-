package lk.ijse.test.entity;

public class Cart {

    private String cartID;
    private String cartName;
    private  String cartCoad;
    private String custID;
    private  String cartDate;

//    public Cart(){
//
//
//    }

    public Cart(String cartID, String cartName, String cartCoad, String custID, String cartDate) {
        this.cartID = cartID;
        this.cartName = cartName;
        this.cartCoad = cartCoad;
        this.custID = custID;
        this.cartDate = cartDate;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public String getCartCoad() {
        return cartCoad;
    }

    public void setCartCoad(String cartCoad) {
        this.cartCoad = cartCoad;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCartDate() {
        return cartDate;
    }

    public void setCartDate(String cartDate) {
        this.cartDate = cartDate;
    }
}

package lk.ijse.test.model;

public class ItemDTO {

    private String id;
    private String itemName;
    private  String itemCode;
    private  String itemUnitPrice;
    private  String itemQty;
    private String expiryDate;

    public ItemDTO(){



    }

    public ItemDTO(String id, String itemName, String itemCode, String itemUnitPrice, String itemQty, String expiryDate) {
        this.id = id;
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemUnitPrice = itemUnitPrice;
        this.itemQty = itemQty;
        this.expiryDate = expiryDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(String itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }






}

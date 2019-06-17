package lk.ijse.test.entity;

public class Catering {

    private String cateringID;
    private String  noOFPlate;
    private String  foodCatagory;


    public Catering() {
    }

    public Catering(String cateringID, String noOFPlate, String foodCatagory) {
        this.cateringID = cateringID;
        this.noOFPlate = noOFPlate;
        this.foodCatagory = foodCatagory;
    }


    public String getCateringID() {
        return cateringID;
    }

    public void setCateringID(String cateringID) {
        this.cateringID = cateringID;
    }

    public String getNoOFPlate() {
        return noOFPlate;
    }

    public void setNoOFPlate(String noOFPlate) {
        this.noOFPlate = noOFPlate;
    }

    public String getFoodCatagory() {
        return foodCatagory;
    }

    public void setFoodCatagory(String foodCatagory) {
        this.foodCatagory = foodCatagory;
    }
}

package lk.ijse.test.dto;

public class CateringDTO {

    private String cateringID;
    private String  noOFPlate;
    private String  foodCatagory;

    public CateringDTO() {


    }


    public CateringDTO(String cateringID, String noOFPlate, String foodCatagory) {
        this.cateringID = cateringID;
        this.noOFPlate = noOFPlate;
        this.foodCatagory = foodCatagory;
    }

    public String getCateringID() {
        return cateringID;
    }

    public void setCaoteringID(String cateringID) {
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

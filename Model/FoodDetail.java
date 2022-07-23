package Model;

import javax.swing.*;

public class FoodDetail {

    private int FoodID;
    private String name;
    private String vendorName;
    private float price;
    private String description;

    public FoodDetail() {
        FoodID = 0;
        name = "";
        vendorName = "";
        price = 0;
        description = "";
    }

    public FoodDetail(int foodID, String name, String vendorName, float price, String description) {
        FoodID = foodID;
        this.name = name;
        this.vendorName = vendorName;
        this.price = price;
        this.description = description;
    }

    public int generateID() {
        return ( FoodID = (int)Math.floor(Math.random()*((999-100)+1)+100) );
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public FoodDetail AddNewFood() {

        FoodDetail foodDetail = new FoodDetail();

        foodDetail.setName(JOptionPane.showInputDialog(null, "Please enter the Food name : "));
        foodDetail.setVendorName(JOptionPane.showInputDialog(null, "Please enter the Vendor name : "));
        foodDetail.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the price : ")));
        foodDetail.setDescription(JOptionPane.showInputDialog(null, "Please enter the description : "));
        foodDetail.setFoodID(generateID());

        return foodDetail;
    }

    public FoodDetail EditFood(int FoodID) {

        FoodDetail foodDetail = new FoodDetail();

        foodDetail.setName(JOptionPane.showInputDialog(null, "Please enter the Food name : "));
        foodDetail.setVendorName(JOptionPane.showInputDialog(null, "Please enter the Vendor name : "));
        foodDetail.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the price in float : ")));
        foodDetail.setDescription(JOptionPane.showInputDialog(null, "Please enter the description : "));
        foodDetail.setFoodID(FoodID);

        return foodDetail;
    }

}

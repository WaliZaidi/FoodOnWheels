package Model;

import java.util.ArrayList;

public class Order {

    private int orderID;
    private int customerID;
    private String status;
    private boolean COD;
    private ArrayList<FoodDetail> foodDetails;

    public Order() {
        orderID = 0;
    }

    public Order(int orderID, ArrayList<FoodDetail> foodDetails) {
        this.orderID = orderID;
        this.foodDetails = foodDetails;
        customerID = 0;
        COD = false;
        status = "";
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<FoodDetail> getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(ArrayList<FoodDetail> foodDetails) {
        this.foodDetails = foodDetails;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCOD() {
        return COD;
    }

    public void setCOD(boolean COD) {
        this.COD = COD;
    }
}

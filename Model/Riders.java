package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Riders implements User {

    Scanner input = new Scanner(System.in);

    FileOperations fileop = new FileOperations();

    private int riderID;
    private String riderPassword;
    private String riderName;
    private int phoneNum;
    private boolean orderTaken;

    Order order = new Order();

    public Riders() {
        riderID = 0;
        riderName = "";
        riderPassword = "";
        phoneNum = 0;
    }

    //getter setters

    public int getRiderID() {
        return riderID;
    }

    public void setRiderID(int riderID) {
        this.riderID = riderID;
    }

    public String getRiderPassword() {
        return riderPassword;
    }

    public void setRiderPassword(String riderPassword) {
        this.riderPassword = riderPassword;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isOrderTaken() {
        return orderTaken;
    }

    public void setOrderTaken(boolean orderTaken) {
        this.orderTaken = orderTaken;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //user functions

    public boolean Login() {

        boolean loginState = false;
        int ID;
        String passwordRider;

        System.out.println("Welcome to Rider Login...");
        System.out.println("Please enter your user ID : ");
        ID = input.nextInt();
        System.out.println("Please enter your password : ");
        passwordRider = input.nextLine();

        if ( (ID == riderID) && (passwordRider.equals(riderPassword)) ) {
            System.out.println("Login Successful.");
            loginState = true;
        }
        else if ( !(ID == riderID)) {
            System.out.println("The user ID is incorrect.");
        }
        else {
            System.out.println("The password is incorrect.");
        }

        return loginState;
    }

    public int DisplayMenu() {
        int riderChoice = 0;

        //mostly call to the GUI from here

        return riderChoice;
    }

    public void AddRider(Riders riders) {
        try {
            fileop.AddRider(riders);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } //add rider to file

    public ArrayList<Order> ViewOrders() {

        ArrayList<Order> orderArrayList = new ArrayList<>();

        try {
            orderArrayList = fileop.readOrderDetails();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return orderArrayList;
    }

    public void AcceptOrder(Riders rider) {
        //maybe change the timing?
        try {
            fileop.AcceptOrder(rider.getOrder().getOrderID());
            rider.setOrderTaken(true); //set the value of order taken to true
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float Checkout(Riders riders) throws IOException {

        float total = 0;

        ArrayList<Order> orderArrayList = fileop.ReadStatusOrder("collected");

        for (Order order : orderArrayList) {
            if (riders.getOrder().getOrderID() == order.getOrderID()) {
                for (FoodDetail foodDetail : order.getFoodDetails()) {
                    total = total + foodDetail.getPrice();
                }
            }
        }

        return total;
    }

    public void CashCollection(Riders rider) throws IOException {

        float totalcash;

        int riderCash = (GenerateID() / 10);

        float orderCash = rider.Checkout(rider);

        try {
            totalcash = riderCash + orderCash;
            fileop.WriteStatusOrder(rider.getOrder().getOrderID(), "delivered");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean Login(int UserID, String Password) {
        return false;
    }

    //create account (arraylist, fileop(add new rider))
    //view order (fileop.readOrderDetails)
    //

}

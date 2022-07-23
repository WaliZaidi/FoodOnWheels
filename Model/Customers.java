package Model;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers implements User {

    private FileOperations fileop = new FileOperations();

    private Scanner input = new Scanner(System.in);

    private String name;
    private int customerID;
    private String customerPassword;
    private int phoneNum;
    private String address;

    private Order orderCart = new Order();

    public Customers() {
        name = "";
        customerID = 0;
        customerPassword = "";
        phoneNum = 0;
        address = "";
    }

    public Customers(String name, String customerPassword, int phoneNum, String address) {
        this.name = name;
        this.customerID = customerID;
        this.customerPassword = customerPassword;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    //getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(Order orderCart) {
        this.orderCart = orderCart;
    }

    //actual functions:

    public boolean Login(int UserID, String Password) {

        boolean login = false;

        try {
            ArrayList<Customers> customersArrayList = fileop.ReadAllCustomers();

            for (Customers customers : customersArrayList) {
                if ( (UserID == customers.customerID) && (customers.customerPassword.equals(Password)) ) {
                    login = true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return login;
    }

    //customer user functions

    public Customers AddCustomer() {

        Customers customers = new Customers();

        customers.setName(JOptionPane.showInputDialog(null, "Please enter the Customer name : "));
        customers.setCustomerID(customers.GenerateID());
        customers.setCustomerPassword(JOptionPane.showInputDialog(null, "Please enter the Customer password : "));
        customers.setPhoneNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the Customer phone number : ")));
        customers.setAddress(JOptionPane.showInputDialog(null, "Please enter the Customer address : "));

        JOptionPane.showMessageDialog(null, "Your ID is " + customers.getCustomerID() + ", remember it!", "Prompt" ,JOptionPane.INFORMATION_MESSAGE);

        return customers;
    }

    public Customers EditCustomer(int customerID) {

        Customers customers = new Customers();

        customers.setName(JOptionPane.showInputDialog(null, "Please enter the Customer name : "));
        customers.setCustomerID(customers.GenerateID());
        customers.setCustomerPassword(JOptionPane.showInputDialog(null, "Please enter the Customer password : "));
        customers.setPhoneNum(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the Customer phone number : ")));
        customers.setAddress(JOptionPane.showInputDialog(null, "Please enter the Customer address : "));
        customers.setCustomerID(customerID);

        return customers;
    }

    public void RemoveCustomer(ArrayList<Customers> customersArrayList, int customerID) {

        for (Customers customers : customersArrayList) {
            if (customerID == customers.getCustomerID()) { //check ID
                customersArrayList.remove(customers); //remove from arraylist
                try {
                    fileop.UpdateCustomers(customersArrayList); //update the files
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //ordering things

    public void NewOrder(int customerID, int FoodID) { //new order in customer and the file itself

        ArrayList<Customers> customersArrayList = new ArrayList<>();

        try {
            customersArrayList = fileop.ReadAllCustomers();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Customers customers = new Customers();

        for(Customers customers_1 : customersArrayList) {
            if (customers_1.getCustomerID() == customerID) {
                customers = customers_1;
            }
        }

        customers.orderCart.setFoodDetails(orderCart.getFoodDetails());

        int foodID = FoodID;

        while (foodID != 0) {
            try {
                customers.orderCart.getFoodDetails().add(fileop.SearchFoodDetail(foodID)); //adds it to the cart for the program
                customers.orderCart.getFoodDetails().add(fileop.SearchFoodDetail(foodID)); //adds it into the files
                foodID = 0;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            fileop.WriteNewOrder(customers); //order passed to file to write into delivery info
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean RemoveOrder(Customers customers) {
        boolean action = true;

        try {
            action = fileop.RemoveOrder(customers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return action;
    }

    public String CheckDeliveryStatus(Customers customers) {
        return (customers.getOrderCart().getStatus());
    }

    public float Checkout(int customerID) {
        float total = 0;

        ArrayList<Customers> customersArrayList = new ArrayList<>();

        try {
            customersArrayList = fileop.ReadAllCustomers();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Customers customers = new Customers();

        for(Customers customers_1 : customersArrayList) {
            if (customers_1.getCustomerID() == customerID) {
                customers = customers_1;
            }
        }

        for (FoodDetail foodDetail : customers.getOrderCart().getFoodDetails()) {
            total = total + foodDetail.getPrice();
        }

        return total;
    }

    public int ShowFoodDetails() {

        int foodID = 0;

        try {
            ArrayList<FoodDetail> foodDetailArrayList = fileop.ReadAllFoodDetails();

            String[] outputString = new String[foodDetailArrayList.size()];

            int count = 0;

            for (FoodDetail foodDetail : foodDetailArrayList) {
                outputString[count] = foodDetail.getFoodID() + " | " + foodDetail.getName() + " | " + foodDetail.getDescription() + " | " + foodDetail.getPrice();
                count++;
            }

            foodID = Integer.parseInt(JOptionPane.showInputDialog(null, " Please choose from \n"+ outputString ));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return foodID;
    }

    //menus

    public boolean CustomerLogin() {
        boolean loginChoice;
        JOptionPane.showMessageDialog(null, "Welcome to Customer Login!!! \n");
        loginChoice = Login((Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the Customer ID :"))), JOptionPane.showInputDialog(null, "Please enter the Customer password : "));
        return loginChoice;
    }

    public int CustomerMenu() {

        int cusChoice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Welcome to the Customer Menu!!!\s
                Please select one of the options :\s
                1. View Food Details\s
                2. Check out\s
                3. Cancel Order\s
                4. Pay COD\s
                5. Check food delivery status\s
                6. Exit"""));

        return cusChoice;
    }

    public int CustomerStartMenu() {

        int cusChoice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Welcome to the Customer Menu!!!\s
                Please select one of the options :\s
                1. Login\s
                2. Add New Customer\s
                3. Back\s"""));

        return cusChoice;
    }


}

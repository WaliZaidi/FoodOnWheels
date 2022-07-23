import Model.*;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        FileOperations fileOperations = new FileOperations();

        //declare the arraylists

        ArrayList<Customers> customersArrayList = new ArrayList<>();
        ArrayList<Vendors> vendorsArrayList = new ArrayList<>();
        ArrayList<Riders> ridersArrayList = new ArrayList<>();
        ArrayList<FoodDetail> foodDetailArrayList = new ArrayList<>();

        try {
            customersArrayList = fileOperations.ReadAllCustomers();
            vendorsArrayList = fileOperations.ReadAllVendors();
            ridersArrayList = fileOperations.ReadAllRiders();
            foodDetailArrayList = fileOperations.ReadAllFoodDetails();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        int menuChoice = 0;

        while (menuChoice != 5) {

            menuChoice = MainMenu();

            if (menuChoice == 1) {  //dont use switch, dont like that

                Admin admin = new Admin(); //make a object for it

                boolean loginChoice;

                loginChoice = admin.AdminLogin();

                if (loginChoice) {

                    JOptionPane.showMessageDialog(null, "Login Successful", "Prompt", JOptionPane.INFORMATION_MESSAGE);

                    int adminChoice = 0;

                    while (adminChoice != 5) {

                        adminChoice = admin.AdminMenu(); //brought in

                        if (adminChoice == 5) {
                            break;
                        }
                        else if (adminChoice == 1) { //manage vendors

                            Vendors vendors = new Vendors();

                            JOptionPane.showMessageDialog(null, "Welcome to Vendor Management", "Prompt", JOptionPane.INFORMATION_MESSAGE);

                            int vendorChoice = admin.VendorMenu();

                            if (vendorChoice == 1) { //add vendor
                                try {
                                    fileOperations.vendorWriter(vendors.AddNewVendor());
                                    vendorsArrayList.add(vendors);
                                    JOptionPane.showMessageDialog(null, "Vendor added successfully" , "Prompt", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else if (vendorChoice == 2) { //remove vendor
                                int removeVendor = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to remove : "));
                                for (Vendors vendors1 : vendorsArrayList) {
                                    if (removeVendor == vendors1.getVendorID()) {
                                        vendorsArrayList.remove(vendors1);
                                        try {
                                            fileOperations.UpdateVendors(vendorsArrayList);
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            else if (vendorChoice == 3) { //edit vendor
                                int EditVendor = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to edit : "));
                                for (Vendors vendors1 : vendorsArrayList) {
                                    if (EditVendor == vendors1.getVendorID()) {
                                        try {
                                            fileOperations.EditVendor(vendors1.EditVendor(EditVendor));
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        else if (adminChoice == 2) { //manage Food Details

                            FoodDetail foodDetail =  new FoodDetail();

                            JOptionPane.showMessageDialog(null, "Welcome to Food Management", "Prompt", JOptionPane.INFORMATION_MESSAGE);

                            int foodChoice = admin.FoodMenu();

                            if (foodChoice == 1) { //add food
                                try {
                                    foodDetail = foodDetail.AddNewFood();
                                    fileOperations.AddFoodDetails(foodDetail);
                                    foodDetailArrayList.add(foodDetail);
                                    JOptionPane.showMessageDialog(null, "Food added successfully" , "Prompt", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else if (foodChoice == 2) { //remove food
                                int removeFood = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to remove : "));
                                for (FoodDetail foodDetail1 : foodDetailArrayList) {
                                    if (removeFood == foodDetail1.getFoodID()) {
                                        foodDetailArrayList.remove(foodDetail1);
                                        try {
                                            fileOperations.UpdateFood(foodDetailArrayList);
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            else if (foodChoice == 3) { //edit food
                                int EditFood = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to edit : "));
                                for (FoodDetail foodDetail1 : foodDetailArrayList) {
                                    if (EditFood == foodDetail1.getFoodID()) {
                                        try {
                                            fileOperations.EditFood(foodDetail1.EditFood(EditFood));
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        else if (adminChoice == 3) {

                            Customers customers = new Customers();

                            JOptionPane.showMessageDialog(null, "Welcome to Customer Management", "Prompt", JOptionPane.INFORMATION_MESSAGE);

                            int cusChoice = admin.CustomerMenu();

                            if (cusChoice == 1) { //add customer
                                try {
                                    customers = customers.AddCustomer();
                                    fileOperations.AddCustomer(customers);
                                    customersArrayList.add(customers);
                                    fileOperations.UpdateCustomers(customersArrayList);
                                    JOptionPane.showMessageDialog(null, "Customer added successfully" , "Prompt", JOptionPane.INFORMATION_MESSAGE);
                                }
                                catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else if (cusChoice == 2) { //remove customer
                                int removeCus = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to remove : "));
                                for (Customers customers1 : customersArrayList) {
                                    if (removeCus == customers1.getCustomerID()) {
                                        customersArrayList.remove(customers1);
                                        try {
                                            fileOperations.UpdateCustomers(customersArrayList);
                                            break;
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            else if (cusChoice == 3) { //edit customer
                                int EditCus = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the ID to edit : "));
                                for (Customers customers1 : customersArrayList) {
                                    if (EditCus == customers1.getCustomerID()) {
                                        try {
                                            fileOperations.EditCustomers(customers.EditCustomer(EditCus));
                                        }
                                        catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        else if (adminChoice == 4) {

                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "The login failed. Please check your ID or Password", "Login Fail", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (menuChoice == 2) {

                Customers customers = new Customers();

                int cusMenuChoice = 0;

                while (cusMenuChoice != 3) {

                    cusMenuChoice = customers.CustomerStartMenu();

                    if (cusMenuChoice == 3) {
                        break;
                    }
                    else if (cusMenuChoice == 1) {
                        boolean loginChoice = false;

                        loginChoice = customers.CustomerLogin();

                        if (loginChoice) {

                            JOptionPane.showMessageDialog(null, "Login Successful", "Prompt", JOptionPane.INFORMATION_MESSAGE);

                            int cusChoice = 0;

                            while (cusChoice != 6) {

                                cusChoice = customers.CustomerMenu();

                                if (cusChoice == 6) {
                                    break;
                                }
                                else if (cusChoice == 1) { //view food details, as well as order

                                    int foodID = customers.ShowFoodDetails(); //using this we already have the food id

                                    customers.NewOrder(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the customer ID once more : ")), foodID);
                                }
                                else if (cusChoice == 2) { //check out
                                    float total = customers.Checkout(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the customer ID once more : ")));
                                }
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "The login failed. Please check your ID or Password", "Login Fail", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if (cusMenuChoice == 2) {



                    }
                }
            }
        }
    }

    private static int MainMenu() {

        int menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome to Food on Wheels!!! \n"
                + "Please select from the following menus :  \n"
                + "1. Admin Menu \n"
                + "2. Customer Menu \n"
                + "3. Vendor Menu \n"
                + "4. Rider Menu \n"
                + "5. Exit"));
        return menuChoice;
    }


}

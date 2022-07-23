package Model;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Admin implements User {

    Scanner input = new Scanner(System.in);

    //FileOperations fileop = new FileOperations();

    private int AdminID;
    private String adminPassword;

    public Admin() {
        AdminID = 33569;
        adminPassword = "password";
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    @Override
    public boolean Login(int UserID, String Password) {

        if (AdminID == UserID) {
            if (adminPassword.equals(Password)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }

    public int DisplayMenu() {

        int adminChoice;

        System.out.println("Welcome to the Admin Menu...");
        System.out.println();
        System.out.println("Please choose from the following : ");
        System.out.println("1. Login");
        System.out.println("2. Manage Vendors");
        System.out.println("3. Manage Vendors Products/Food");
        System.out.println("4. Manage Customers");
        System.out.println("5. Manage Food Order Details");
        System.out.println("6. Manage Payment Details");
        System.out.println("7. Manage Riders");
        System.out.print("Please enter the choice : ");
        adminChoice = input.nextInt();

        while ( (adminChoice < 0) || (adminChoice > 7) ) {
            System.out.println("Please enter a number b/w 0 and 7.");
            System.out.print("Please enter the choice : ");
            adminChoice = input.nextInt();
        }

        return adminChoice;
    }

    public void ManageVendors(Vendors vendors) throws IOException {

//        ArrayList<Vendors> vendorsArrayList = new ArrayList<>();
//
//        System.out.println("Welcome to the Manage Vendors Menu... ");
//        System.out.println();
//        System.out.println("Please select one from the following : ");
//        System.out.println("1. Add a new Vendor");
//        System.out.println("2. Remove a Vendor");
//        System.out.println("3. Display All Vendors");
//        int vendorChoice = input.nextInt();
//
//        while ( (vendorChoice < 0) || (vendorChoice > 3)) {
//            System.out.println("Please enter a number b/w 0 and 3.");
//            System.out.print("Please enter the choice : ");
//            vendorChoice = input.nextInt();
//        }
//
//        if (vendorChoice == 1) {
//            fileop.vendorWriter(vendors);
//        }
//        else if (vendorChoice == 2) {
//
//        }
//        else if (vendorChoice == 3) {
//            vendorsArrayList = fileop.ReadAllVendors();
//            for (Vendors vendors1 : vendorsArrayList) {
//                //we will implement the vendor output over here
//            }
//        }
        //call to main menu once this is done, but that is in the main
    }

    public void AddUser() {

    }

    public void RemoveUser() {

    }

    public void DisplayUsers() {

    }

    public int AdminMenu() {

        int adminChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome to the Admin Menu!!! \n"
                + "Please select one of the options : \n"
                + "1. Manage Vendors \n"
                + "2. Manage Food Details \n"
                + "3. Manage Customers \n"
                + "4. Manage Riders \n"
                + "5. Return to Main Menu"));

        return adminChoice;
    }

    public boolean AdminLogin() {
        boolean loginChoice;
        JOptionPane.showMessageDialog(null, "Welcome to Admin Login!!! \n");
        loginChoice = Login((Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the Admin ID :"))), JOptionPane.showInputDialog(null, "Please enter the Admin Password : "));
        return loginChoice;
    }

    public int VendorMenu() {

        int vendorChoice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Welcome to the Manage Vendor Menu!!!\s
                Please select one of the options :\s
                1. Add Vendors\s
                2. Delete Vendors\s
                3. Edit Vendors\s
                """));

        return vendorChoice;
    }

    public int FoodMenu() {

        int FoodChoice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Welcome to the Manage Food Menu!!!\s
                Please select one of the options :\s
                1. Add Food\s
                2. Delete Food\s
                3. Edit Food\s
                """));

        return FoodChoice;
    }

    public int CustomerMenu() {

        int CustomerChoice = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Welcome to the Manage Customer Menu!!!\s
                Please select one of the options :\s
                1. Add Customer\s
                2. Delete Customer\s
                3. Edit Customer\s
                """));

        return CustomerChoice;
    }

}

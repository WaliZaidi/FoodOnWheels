package Model;

import javax.swing.*;

public class Vendors implements User {

    private int vendorID;
    private String name;
    private String password;
    private String address;
    private FoodDetail[] detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FoodDetail[] getDetail() {
        return detail;
    }

    public void setDetail(FoodDetail[] detail) {
        this.detail = detail;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean Login(int UserID, String Password) {
        return false;
    }

    public Vendors AddNewVendor() {

        Vendors vendors = new Vendors();

        vendors.setName(JOptionPane.showInputDialog(null, "Please enter the Vendor name : "));
        vendors.setPassword(JOptionPane.showInputDialog(null, "Please enter the Vendor password : "));
        vendors.setAddress(JOptionPane.showInputDialog(null, "Please enter the Vendor address : "));
        vendors.setVendorID(GenerateID());

        JOptionPane.showMessageDialog(null, "Your ID is " + vendors.getVendorID() + ", remember it!", "Prompt" ,JOptionPane.INFORMATION_MESSAGE);

        return vendors;
    }

    public Vendors EditVendor(int VendorID) {

        Vendors vendors = new Vendors();

        vendors.setName(JOptionPane.showInputDialog(null, "Please enter the Vendor name : "));
        vendors.setPassword(JOptionPane.showInputDialog(null, "Please enter the Vendor password : "));
        vendors.setAddress(JOptionPane.showInputDialog(null, "Please enter the Vendor address : "));
        vendors.setVendorID(VendorID);

        return vendors;
    }

}

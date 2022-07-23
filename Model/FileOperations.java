package Model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileOperations {

    File customers = new File("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Customers.txt");

    File vendor = new File("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Vendors.txt");

    File rider = new File("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Riders.txt");

    File deliveryInfo = new File("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\DeliveryInfo.txt");

    File foodDetail = new File("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\FoodDetail.txt");

    //making the customer file handling procedures

    public void AddCustomer(Customers cusArr) throws IOException { //the arraylist will search the customer, and send it here, using the (for:) loop

        FileWriter customerWriter = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Customers.txt", true);

        if (customers.createNewFile()) {
            System.out.println("File created " + "Customer.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        String name = cusArr.getName();
        String ID = Integer.toString(cusArr.getCustomerID());
        String password = cusArr.getCustomerPassword();
        String phoneNum = Integer.toString(cusArr.getPhoneNum());
        String address = cusArr.getAddress();

        customerWriter.append(name).append(";").append(ID).append(";").append(password).append(";").append(phoneNum).append(";").append(address).append("\r\n");

        System.out.println("File Record has been added");

        customerWriter.flush();
        customerWriter.close();

    }

    public ArrayList<Customers> ReadAllCustomers() throws IOException { //returns arraylist

        if(customers.createNewFile()) {
            System.out.println("File Created : " + " Customers");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Customers.txt");
        }
        else {
            System.out.println("File already exists.");
        }

        Customers[] cusArr;

        int counter = GetFileLength(customers);

        cusArr = new Customers[counter];

        for (int i = 0; i < counter; i++) {
            cusArr[i] = new Customers();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(customers))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

                cusArr[readCount].setName(strings[0]);
                cusArr[readCount].setCustomerID(Integer.parseInt(strings[1]));
                cusArr[readCount].setCustomerPassword(strings[2]);
                cusArr[readCount].setPhoneNum(Integer.parseInt(strings[3]));
                cusArr[readCount].setAddress(strings[4]);
                readCount++;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Customers> customersArrayList = new ArrayList<>();

        Collections.addAll(customersArrayList, cusArr);

        System.out.println();

        return customersArrayList;
    }

    public void UpdateCustomers(ArrayList<Customers> customersArrayList) throws IOException {

        Customers[] cusArr = new Customers[customersArrayList.size()];

        for (int i = 0; i < (customersArrayList.size()); i++) {
            cusArr[i] = new Customers();
        }

        int i = 0;

        for (Customers customers : customersArrayList) {
            cusArr[i] = customers;
            i++;
        }

        FileWriter customerWriter = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Customers.txt");

        if (customers.createNewFile()) {
            System.out.println("File created " + "Customer.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        for (int j = 0; j < cusArr.length; j++) {
            String name = cusArr[j].getName();
            String ID = Integer.toString(cusArr[j].getCustomerID());
            String password = cusArr[j].getCustomerPassword();
            String phoneNum = Integer.toString(cusArr[j].getPhoneNum());
            String address = cusArr[j].getAddress();

            customerWriter.append(name).append(";").append(ID).append(";").append(password).append(";").append(phoneNum).append(";").append(address).append("\r\n");

        }

        System.out.println("File Record has been updated");

        customerWriter.flush();
        customerWriter.close();

    }

    public void EditCustomers(Customers customers) throws IOException{

        ArrayList<Customers> customersArrayList = ReadAllCustomers();

        boolean found = false;

        for (Customers cus : customersArrayList) {
            if (cus.getCustomerID() == customers.getCustomerID()) {
                customersArrayList.remove(cus);
                found = true;
            }
        }

        if (found) {
            AddCustomer(customers); //add customer info to the file
        }


    }

    //making the vendor file handling procedures

    public void vendorWriter(Vendors vendors) throws IOException { //the arraylist will search the customer, and send it here, using the (for:) loop

        FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Vendors.txt", true);

        if (vendor.createNewFile()) {
            System.out.println("File created " + "Vendors.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        String name = vendors.getName();
        String ID = Integer.toString(vendors.getVendorID());
        String password = vendors.getPassword();
        String address = vendors.getAddress();

        writer.append(ID).append(";").append(name).append(";").append(password).append(";").append(address).append("\r\n");

        System.out.println("File Record has been added");

        writer.flush();
        writer.close();

    }

    public ArrayList<Vendors> ReadAllVendors() throws IOException {

        if(vendor.createNewFile()) {
            System.out.println("File Created : " + "Vendors");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Vendors.txt");

        }
        else {
            System.out.println("File already exists.");
        }

        Vendors[] vendorArr;

        int counter = GetFileLength(vendor);

        vendorArr = new Vendors[counter];

        for (int i = 0; i < counter; i++) {
            vendorArr[i] = new Vendors();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(vendor))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

                vendorArr[readCount].setVendorID(Integer.parseInt(strings[0]));
                vendorArr[readCount].setName(strings[1]);
                vendorArr[readCount].setPassword(strings[2]);
                vendorArr[readCount].setAddress(strings[3]);
                readCount++;

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Vendors> vendorArrayList = new ArrayList<>();

        Collections.addAll(vendorArrayList, vendorArr);

        return vendorArrayList;
    }

    public void UpdateVendors(ArrayList<Vendors> vendorsArrayList) throws IOException {

        Vendors[] vendors = new Vendors[vendorsArrayList.size()];

        for (int i = 0; i < (vendorsArrayList.size()); i++) {
            vendors[i] = new Vendors();
        }

        int i = 0;

        for (Vendors vendors1 : vendorsArrayList) {
            vendors[i] = vendors1;
            i++;
        }

        FileWriter VendorWriter = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Vendors.txt", true);

        if (vendor.createNewFile()) {
            System.out.println("File created " + "Vendors.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        for (int j = 0; j < vendors.length; j++) {

            String name = vendors[i].getName();
            String ID = Integer.toString(vendors[i].getVendorID());
            String password = vendors[i].getPassword();
            String address = vendors[i].getAddress();

            VendorWriter.append(ID).append(";").append(name).append(";").append(password).append(";").append(address).append("\r\n");

        }

        System.out.println("File Record has been updated");

        VendorWriter.flush();
        VendorWriter.close();

    }

    public void EditVendor(Vendors vendor) throws IOException {

        boolean found = false;

        ArrayList<Vendors> vendorsArrayList = ReadAllVendors();

        for (Vendors vendors : vendorsArrayList) {
            if (vendor.getVendorID() == vendors.getVendorID()) {
                vendorsArrayList.remove(vendors);
                found = true;
            }
        }

        if (found) {
            vendorWriter(vendor); //add customer info to the file
        }

    }

    //making the rider file handling procedures

    public void AddRider(Riders riders) throws IOException { //the arraylist will search the customer, and send it here, using the (for:) loop

        FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Riders.txt", true);

        if (rider.createNewFile()) {
            System.out.println("File created " + "Riders.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        writer.append(Integer.toString(riders.getRiderID())).append(";").append(riders.getRiderName()).append(";").append(Integer.toString(riders.getPhoneNum())).append(";").append(Boolean.toString(riders.isOrderTaken())).append("\r\n");

        System.out.println("File Record has been added");

        writer.flush();
        writer.close();
    } //adds a new rider to the file

    public ArrayList<Riders> ReadAllRiders() throws IOException {

        if(vendor.createNewFile()) {
            System.out.println("File Created : " + "Riders");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\Riders.txt");

        }
        else {
            System.out.println("File already exists.");
        }

        Riders[] riderArr;

        int counter = GetFileLength(rider);

        riderArr = new Riders[counter];

        for (int i = 0; i < counter; i++) {
            riderArr[i] = new Riders();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rider))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

//                vendorArr[readCount].setName(strings[0]);
//                vendorArr[readCount].setCustomerID(Integer.parseInt(strings[1]));
//                vendorArr[readCount].setCustomerPassword(strings[2]);
//                vendorArr[readCount].setPhoneNum(Integer.parseInt(strings[3]));
//                vendorArr[readCount].setAddress(strings[4]);
                //readCount++;

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Riders> ridersArrayList = new ArrayList<>();

        Collections.addAll(ridersArrayList, riderArr);

        return ridersArrayList;
    }

    public void AcceptOrder(int OrderID) throws IOException{

        ArrayList<Order> orderArrayList = ReadStatusOrder("pending");

        for (Order order : orderArrayList) {
            if (OrderID == order.getOrderID()) {
                order.setStatus("collected");
            }
        }

    }

    //the food detail functions go here

    public void AddFoodDetails(FoodDetail foodItem) throws IOException {

        FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\FoodDetail.txt", true);

        if (foodDetail.createNewFile()) {
            System.out.println("File created " + "FoodDetail.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        int foodID = foodItem.getFoodID();
        String name = foodItem.getName();
        String vendorName = foodItem.getVendorName();
        float price = foodItem.getPrice();
        String description = foodItem.getDescription();


        writer.append(Integer.toString(foodID)).append(";").append(name).append(";").append(vendorName).append(";").append(Float.toString(price)).append(";").append(description).append("\r\n");

        System.out.println("File Record has been added");

        writer.flush();
        writer.close();

    }

    public ArrayList<FoodDetail> ReadAllFoodDetails() throws IOException {

        if(foodDetail.createNewFile()) {
            System.out.println("File Created : " + "FoodDetail");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\FoodDetail.txt");

        }
        else {
            System.out.println("File already exists.");
        }

        FoodDetail[] foodArr;

        int counter = GetFileLength(foodDetail);

        foodArr = new FoodDetail[counter];

        for (int i = 0; i < counter; i++) {
            foodArr[i] = new FoodDetail();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(foodDetail))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

                foodArr[readCount].setFoodID(Integer.parseInt(strings[0]));
                foodArr[readCount].setName(strings[1]);
                foodArr[readCount].setVendorName(strings[2]);
                foodArr[readCount].setPrice(Float.parseFloat(strings[3]));
                foodArr[readCount].setDescription(strings[4]);

                readCount++;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<FoodDetail> foodDetailArrayList = new ArrayList<>();

        Collections.addAll(foodDetailArrayList, foodArr);

        return foodDetailArrayList;
    }

    public FoodDetail SearchFoodDetail(int foodID) throws IOException{

            if(foodDetail.createNewFile()) {
                System.out.println("File Created : " + "FoodDetail");
                FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\FoodDetail.txt");

            }
            else {
                System.out.println("File already exists.");
            }

            FoodDetail foodArr;

            int counter = GetFileLength(foodDetail);

            foodArr = new FoodDetail();

            int readCount = 0;

            boolean found = false;

            try (BufferedReader br = new BufferedReader(new FileReader(foodDetail))) {

                String line;

                while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                    String[] strings = line.split(";");

                    if (foodID == (Integer.parseInt(strings[0]))) {

                        foodArr.setFoodID(Integer.parseInt(strings[0]));
                        foodArr.setName(strings[1]);
                        foodArr.setVendorName(strings[2]);
                        foodArr.setPrice(Float.parseFloat(strings[3]));
                        foodArr.setDescription(strings[4]);
                        found = true;
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            if (found) {
                return foodArr;
            }
            else
            {
                return null;
            }
    }

    public void UpdateFood(ArrayList<FoodDetail> foodDetailArrayList) throws IOException{

        FoodDetail[] foodDetails = new FoodDetail[foodDetailArrayList.size()];

        for (int i = 0; i < (foodDetailArrayList.size()); i++) {
            foodDetails[i] = new FoodDetail();
        }

        int i = 0;

        for (FoodDetail foodDetail1 : foodDetailArrayList) {
            foodDetails[i] = foodDetail1;
            i++;
        }

        FileWriter FoodWriter = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\FoodDetail.txt", true);

        if (foodDetail.createNewFile()) {
            System.out.println("File created " + "FoodDetail.txt");
        }
        else {
            System.out.println("File already exists. "); //check for file
        }

        for (int j = 0; j < foodDetails.length; j++) {

            int foodID = foodDetails[i].getFoodID();
            String name = foodDetails[i].getName();
            String vendorName = foodDetails[i].getVendorName();
            float price = foodDetails[i].getPrice();
            String description = foodDetails[i].getDescription();


            FoodWriter.append(Integer.toString(foodID)).append(";").append(name).append(";").append(vendorName).append(";").append(Float.toString(price)).append(";").append(description).append("\r\n");
        }

        System.out.println("File Record has been updated");

        FoodWriter.flush();
        FoodWriter.close();

    }

    public void EditFood(FoodDetail food) throws IOException {

        boolean found = false;

        ArrayList<FoodDetail> foodDetailArrayList = ReadAllFoodDetails();

        for (FoodDetail foodDetail : foodDetailArrayList) {
            if (foodDetail.getFoodID() == food.getFoodID()) {
                foodDetailArrayList.remove(foodDetail);
                found = true;
            }
        }

        if (found) {
            AddFoodDetails(food); //add customer info to the file
        }

    }

    //making the order info file handling procedures

    public void WriteNewOrder(Customers cusArr) throws IOException{

        String status = "";

        FileWriter writer = new FileWriter(deliveryInfo.getAbsolutePath(), true);

        if (deliveryInfo.createNewFile()) {
            System.out.println("New File Created : DeliveryInfo.txt");
        }
        else {
            System.out.println("File already exists.");
        }

        writer.append(Integer.toString(cusArr.getOrderCart().getOrderID())).append(";").append(Integer.toString(cusArr.getCustomerID())).append(";").append(status).append(";");

        writer.append("\r\n");

        System.out.println("File Record Added.");

        writer.flush();
        writer.close();
    }

    public ArrayList<Order> readOrderDetails() throws IOException {

        if(deliveryInfo.createNewFile()) {
            System.out.println("File Created : " + "DeliveryInfo");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\DeliveryInfo.txt");

        }
        else {
            System.out.println("File already exists.");
        }

        Order[] orders;

        int counter = GetFileLength(deliveryInfo);

        orders = new Order[counter];

        for (int i = 0; i < counter; i++) {
            orders[i] = new Order();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(deliveryInfo))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

                orders[readCount].setOrderID(Integer.parseInt(strings[0]));
                orders[readCount].setCustomerID(Integer.parseInt(strings[1]));
                orders[readCount].setStatus(strings[2]);

                readCount++;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Order> orderArrayList = new ArrayList<>();

        Collections.addAll(orderArrayList, orders);

        return orderArrayList;
    }

    public ArrayList<Order> ReadStatusOrder(String status) throws IOException {

        if(deliveryInfo.createNewFile()) {
            System.out.println("File Created : " + "DeliveryInfo");
            FileWriter writer = new FileWriter("E:\\Wali\\Java\\IntelliJ Files\\OOP_Project\\src\\Data Files\\DeliveryInfo.txt");

        }
        else {
            System.out.println("File already exists.");
        }

        Order[] orders;

        int counter = GetFileLength(deliveryInfo);

        orders = new Order[counter];

        for (int i = 0; i < counter; i++) {
            orders[i] = new Order();
        }

        int readCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(deliveryInfo))) {

            String line;

            while ( ((line = br.readLine()) != null) && (readCount < counter) ) {

                String[] strings = line.split(";");

                if (strings[2].equals(status.toLowerCase())) {
                    orders[readCount].setOrderID(Integer.parseInt(strings[0]));
                    orders[readCount].setCustomerID(Integer.parseInt(strings[1]));
                    orders[readCount].setStatus(strings[2]);
                }

                readCount++;

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Order> orderArrayList = new ArrayList<>();

        Collections.addAll(orderArrayList, orders);

        return orderArrayList;
    }

    public boolean RemoveOrder(Customers customers) throws IOException {

        boolean action = true;

        ArrayList<Order> orderArrayList = readOrderDetails();

        boolean found = false;

        for (Order order1 : orderArrayList) {
            if (customers.getOrderCart().getOrderID() == order1.getOrderID()) {
                orderArrayList.remove(order1);
                found = true;
            }
        }

        if (found) {
            WriteNewOrder(customers);
        }
        else {
            action = false;
        }
        return action;
    }

    public void WriteStatusOrder(int OrderID, String status) throws IOException{

        ArrayList<Order> orderArrayList = readOrderDetails();

        for (Order order : orderArrayList) {
            if (OrderID == order.getOrderID()) {
                order.setStatus(status);
            }
        }

    }

    //other functions

    protected int GetFileLength(File targetFile) throws IOException{

        int counter = 0;

        try (BufferedReader brrrr = new BufferedReader(new FileReader(targetFile))) {
            String line;

            while ((line = brrrr.readLine()) != null) {
                counter++;
            }
            brrrr.close();
        }

        return counter;
    }

    protected int GenerateID() {

        int ID = 0;

        ID = (int)Math.floor(Math.random()*((9999-1000)+1)+1000);

        return ID;
    }

    //the other functions to be used by the customer class are here

    public void ViewFoodDetails() {

        try {

            ArrayList<FoodDetail> foodDetailArrayList = ReadAllFoodDetails();

            for (FoodDetail food : foodDetailArrayList) {
                System.out.println("ID : " + food.getFoodID() + " | " + "Name : " + food.getName() + " | " + "Vendor Name : " + food.getVendorName() + " | " + "Price : " + food.getPrice() + " | " + "Description : " + food.getDescription() + " \n");
            }

            //this needs to be converted into the controller stuff

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }







}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    public static final Product[] INVENTORY_ARRAY = createAllInventory();

    private static Product[] createAllInventory () {
        List <Product> inventoryList = new ArrayList<>();
       File inventory = new File ("C:\\PROJECTS\\capstone\\Capstone Project 1\\capstone-1\\vendingmachine.csv");
       try (Scanner inventoryReader = new Scanner (inventory)) {
           while (inventoryReader.hasNextLine()) {
               String lineOfText = inventoryReader.nextLine();
               String [] informationForTheProduct = lineOfText.split("\\|");
               String productLocation = informationForTheProduct [0];
               String productName = informationForTheProduct [1];
               double productPrice = Double.parseDouble(informationForTheProduct [2]);
               String productType = informationForTheProduct [3];
               Product newProduct = new Product (productName, productPrice, productType, productLocation);
               inventoryList.add (newProduct);
           }
       } catch (FileNotFoundException e) {
           System.out.println("file not found");
       }
       Product [] productArray = new Product[inventoryList.size ()];
       return inventoryList.toArray(productArray);
    }
    public static void restock () {
        for (Product product : INVENTORY_ARRAY) {
            product.setStock(5);
        }
    }
    public static void displayInventory(){
        for (Product product : INVENTORY_ARRAY) {
            System.out.println(product);
        }
    }


}

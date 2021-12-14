package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    public static final Product[] INVENTORY_ARRAY = createAllInventory();

    private static Product[] createAllInventory () {
        List <Product> inventoryList = new ArrayList<>();
       File inventory = new File ("vendingmachine.csv");
       try (Scanner inventoryReader = new Scanner (inventory)) {
           while (inventoryReader.hasNextLine()) {
               String lineOfText = inventoryReader.nextLine();
               String [] informationForTheProduct = lineOfText.split("|");
               Product newProduct = new Product (informationForTheProduct [1], Double.parseDouble(informationForTheProduct [2]),
 informationForTheProduct [3], informationForTheProduct [0]);
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
        for
    }


}

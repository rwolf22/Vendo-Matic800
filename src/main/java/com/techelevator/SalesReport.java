package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.security.Key;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class SalesReport {

    private static Map <String, Integer> salesReport = createMap();

    private static Map <String, Integer> createMap () {

        Map <String, Integer> returnMap = new HashMap<>();

        for (Product x : Inventory.INVENTORY_ARRAY){

            returnMap.put(x.getName(),0);

        }

        return returnMap;
    }

    public static void sellProduct (String productToSell){

        salesReport.put(productToSell, salesReport.get(productToSell) + 1);

    }

    public static void printSalesReport (){

        File salesReportFile = new File("SalesReport.txt");

        int totalSales = 0;

        try (PrintWriter writer = new PrintWriter(salesReportFile)){

            for (String key : salesReport.keySet()){

                double itemPrice = 0;

                for (Product item : Inventory.INVENTORY_ARRAY){

                    if (item.getName().equals(key)){

                        itemPrice = item.getPrice();

                    }
                }

                totalSales += itemPrice * salesReport.get(key);

                writer.println(key + "|" + salesReport.get(key));
            }
            NumberFormat currency = NumberFormat.getCurrencyInstance();

            writer.println();

            writer.println("Total Sales : " + currency.format(totalSales));

        } catch (Exception e){

            System.out.println("File Not Found");
        }
    }
}

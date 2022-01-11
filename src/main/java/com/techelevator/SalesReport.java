package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void addToReport(String productToSell){
        salesReport.put(productToSell, salesReport.get(productToSell) + 1);
    }

    public static void clearReport(){
        salesReport.replaceAll((k, v) -> 0);
    }

    public static void printSalesReport() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("MMddyyyy_HHmmss");
        String formattedDate = now.format(myFormat);

        File currentSalesReport = new File("SalesReports\\Sales_Report_" + formattedDate + ".txt");

        try {
            if (currentSalesReport.createNewFile()) {
                try (PrintWriter writer = new PrintWriter(currentSalesReport)){
                    double totalSales = 0;
                    for (String key: salesReport.keySet()) {
                        for (Product item: Inventory.INVENTORY_ARRAY) {
                            if (item.getName().equalsIgnoreCase(key)) {
                                totalSales += salesReport.get(key) * item.getPrice();
                            }
                        }
                        writer.println(key + "|" + salesReport.get(key));
                    }
                    NumberFormat currency = NumberFormat.getCurrencyInstance();
                    writer.println("TOTAL SALES|" + currency.format(totalSales));
                }catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
            }
            else {
                System.out.println("Cannot create the file: " + currentSalesReport.getName());
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        clearReport();
    }
}

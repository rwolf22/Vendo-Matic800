package com.techelevator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    public static void log(String action, double moneyBefore, double moneyAfter) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String formattedDate = now.format(myFormat);

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        File logFile = new File("Log.txt");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.println(formattedDate + " " + action + " " + currency.format(moneyBefore) + " " + currency.format(moneyAfter));
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }



}


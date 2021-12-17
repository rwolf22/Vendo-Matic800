package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AuditTest {

    @Test
    public void auditLogTest() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String formattedDate = now.format(myFormat);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String expected = formattedDate + " Test $17.05 $67.55";
        Audit.log("Test", 17.05, 67.55);
        String logLineOfText = "";
        try (Scanner reader = new Scanner(new File("Log.txt"))){
            logLineOfText = reader.nextLine();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        Assert.assertEquals(expected, logLineOfText);
    }
}

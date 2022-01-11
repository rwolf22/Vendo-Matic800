package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private Product testChip;
    private Product testCandy;
    private Product testDrink;
    private Product testGum;

    @Before
    public void createTestProducts() {
        testChip = new Product("Test Chip", 1.25, "Chip", "A1");
        testCandy = new Product("Test Candy", 2.50, "Candy", "A2");
        testDrink = new Product("Test Drink", 3.75, "Drink", "A3");
        testGum = new Product("Test Gum", 5.00, "Gum", "A4");
    }

    @Test
    public void toStringTest() {
        String expected = "A1) Test Chip $1.25";
        Assert.assertEquals(expected, testChip.toString());
    }

    @Test
    public void dispenseChipTest() {
        String expected = "Crunch Crunch, Yum!";
        Assert.assertEquals(expected, testChip.dispensingMessage());
    }

    @Test
    public void dispenseCandyTest() {
        String expected = "Munch Munch, Yum!";
        Assert.assertEquals(expected, testCandy.dispensingMessage());
    }

    @Test
    public void dispensingDrinkTest() {
        String expected = "Glug Glug, Yum!";
        Assert.assertEquals(expected, testDrink.dispensingMessage());
    }

    @Test
    public void dispensingGumTest() {
        String expected = "Chew Chew, Yum!";
        Assert.assertEquals(expected, testGum.dispensingMessage());
    }

    @Test
    public void sellProductTest() {
        testGum.sellProduct();
        Assert.assertEquals(4, testGum.getStock());
    }

    @After
    public void restock() {
        testChip.setStock(5);
        testCandy.setStock(5);
        testDrink.setStock(5);
        testGum.setStock(5);
    }
}

package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineCLITest {

    @Test
    public void makeChangeAllQuartersTest() {
        String expected = "Returning 4 quarters, 0 dimes, and 0 nickles.";
        Assert.assertEquals(expected, VendingMachineCLI.makeChange(1.00));
    }

    @Test
    public void makeChangeAllDimes() {
        String expected = "Returning 0 quarters, 2 dimes, and 0 nickles.";
        Assert.assertEquals(expected, VendingMachineCLI.makeChange(.20));
    }

    @Test
    public void makeChangeAllNickles() {
        String expected = "Returning 0 quarters, 0 dimes, and 1 nickles.";
        Assert.assertEquals(expected, VendingMachineCLI.makeChange(.05));
    }

    @Test
    public void makeChangeMixedCoins() {
        String expected = "Returning 1 quarters, 1 dimes, and 1 nickles.";
        Assert.assertEquals(expected, VendingMachineCLI.makeChange(.40));
    }
}

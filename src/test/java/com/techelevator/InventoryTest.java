package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

    @Test
    public void restockTest() {
        int numOfRestockedProducts = 0;
        for (Product x: Inventory.INVENTORY_ARRAY) {
            if (x.getStock() == 5) {
                numOfRestockedProducts++;
            }
        }
        Assert.assertEquals(numOfRestockedProducts, Inventory.INVENTORY_ARRAY.length);
    }
}

package com.techelevator;

public class Product {
    private String name;
    private double price;
    private String typeOfProduct;
    private String location;
    private int stock = 5;

    public Product(String name, double price, String typeOfProduct, String location) {
        this.name = name;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
        this.location = location;
    }

    @Override
    public String toString() {
        if (typeOfProduct.equalsIgnoreCase("Chip")) {
            return "Crunch Crunch Yum";
        }
        else if (typeOfProduct.equalsIgnoreCase("Candy")) {
            return "Munch Munch Yum"; }

        else if (typeOfProduct.equalsIgnoreCase("Drink")) {
            return "Glug Glug Yum"; }

        else if (typeOfProduct.equalsIgnoreCase("Gum")) {
            return "Chew Chew Yum"; }

        else {
            return "Do Not Have Type";
        }

    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}


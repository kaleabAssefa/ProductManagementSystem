package com.productmanagement.model;

public class Product extends BaseRecord {

    private String productName;
    private String category;
    private double price;
    private int availableQuantity;

    public Product(
            int productId,
            String productName,
            String category,
            double price,
            int availableQuantity
    ) {
        super(productId);
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------");
        System.out.println("Product ID: " + getId());
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println("Available Quantity: " + availableQuantity);
    }
}
package com.productmanagement.model;
/**
 * Product.java
 * ------------
 * Represents one product in the system.
 * This is a plain class (not abstract) because we DO want to create
 * real Product objects like: new Product(101, "Laptop", ...)
 */
public class Product {

    // ENCAPSULATION: all fields are private
    private int productId;
    private String productName;
    private String category;
    private double price;
    private String description;

    public Product(int productId, String productName, String category,
                   double price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    // ---------- Getters and Setters ----------
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // A simple method to neatly print product details.
    public void displayProduct() {
        System.out.println("---------------------------------------------------");
        System.out.println("Product ID   : " + productId);
        System.out.println("Name         : " + productName);
        System.out.println("Category     : " + category);
        System.out.println("Price        : Rs. " + price);
        System.out.println("Description  : " + description);
    }
}
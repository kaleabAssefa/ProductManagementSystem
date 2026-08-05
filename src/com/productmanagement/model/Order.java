package com.productmanagement.model;

/**
 * Order.java
 * ----------
 * Represents a customer order for a product.
 */
public class Order {

    private int orderId;
    private int customerId;   // links to a Customer
    private int productId;    // links to a Product
    private int quantity;
    private double totalAmount;
    private String orderDate;
    private String orderStatus; // e.g. "Placed", "Shipped", "Delivered", "Cancelled"

    public Order(int orderId, int customerId, int productId, int quantity,
                 String orderDate, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = 0.0; // calculated later using calculateTotalAmount()
    }

    // ---------- Getters and Setters ----------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Business logic method: calculates the order's total amount
     * based on the product's price and the quantity ordered.
     * This method is called from the main system after looking up the
     * product price.
     */
    public void calculateTotalAmount(double unitPrice) {
        this.totalAmount = unitPrice * this.quantity;
    }

    public void displayOrder() {
        System.out.println("---------------------------------------------------");
        System.out.println("Order ID       : " + orderId);
        System.out.println("Customer ID    : " + customerId);
        System.out.println("Product ID     : " + productId);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Total Amount   : Rs. " + totalAmount);
        System.out.println("Order Date     : " + orderDate);
        System.out.println("Order Status   : " + orderStatus);
    }
}

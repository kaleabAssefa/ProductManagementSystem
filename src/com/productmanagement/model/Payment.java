package com.productmanagement.model;
public class Payment {

    private int paymentId;
    private int orderId;
    private double amountPaid;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(int paymentId, int orderId, double amountPaid,
                   String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void displayPayment() {
        System.out.println("---------------------------------------------------");
        System.out.println("Payment ID     : " + paymentId);
        System.out.println("Order ID       : " + orderId);
        System.out.println("Amount Paid    : Rs. " + amountPaid);
        System.out.println("Payment Method : " + paymentMethod);
        System.out.println("Payment Status : " + paymentStatus);
    }
}

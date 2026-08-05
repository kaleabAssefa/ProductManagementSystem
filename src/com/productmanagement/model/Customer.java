package com.productmanagement.model;
public class Customer extends Person {

    private int customerId;
    public Customer(int customerId, String name, String contactNumber) {
        super(name, contactNumber); // calls Person's constructor
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    @Override
    public void displayDetails() {
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Name          : " + getName());
        System.out.println("Contact No.   : " + getContactNumber());
    }
}
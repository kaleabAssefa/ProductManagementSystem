package com.productmanagement.model;

/**
 * Customer.java
 * -------------
 * This class EXTENDS (inherits from) Person.
 * That means Customer automatically gets "name" and "contactNumber"
 * (through getName/setName etc.) without rewriting that code.
 * This is INHERITANCE in action.
 */
public class Customer extends Person {

    private int customerId;

    // The constructor calls the parent class constructor using super(...)
    // super(...) MUST be the first line in the constructor.
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

    /**
     * POLYMORPHISM (Method Overriding):
     * We are providing our OWN implementation of the abstract method
     * declared in Person. The @Override annotation tells Java (and other
     * programmers) "this method is intentionally replacing the parent's
     * version".
     */
    @Override
    public void displayDetails() {
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Name          : " + getName());
        System.out.println("Contact No.   : " + getContactNumber());
    }
}
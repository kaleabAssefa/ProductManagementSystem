package com.productmanagement.model;

/**
 * Person.java
 * -----------
 * This is an ABSTRACT CLASS.
 *
 * WHY ABSTRACT?
 * We use "abstract" here to demonstrate ABSTRACTION - one of the 4 OOP pillars.
 * An abstract class cannot be used to create objects directly
 * (you cannot write: new Person(...)).
 * Instead, it acts as a "template" that other classes (like Customer) must
 * extend and complete.
 *
 * WHY THIS CLASS EXISTS:
 * Both "Customer" (and potentially "Employee/Admin" in a bigger system) share
 * common information: a name and a contact number. Instead of writing that
 * code twice, we put the shared/common fields here and let other classes
 * INHERIT (reuse) them.
 */
public abstract class Person {

    // ENCAPSULATION: fields are private, so they can only be accessed
    // through the public getter/setter methods below. This protects the data.
    private String name;
    private String contactNumber;

    // Constructor: runs automatically when a child class object is created
    public Person(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    // ---------- Getters and Setters (Encapsulation) ----------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * ABSTRACT METHOD:
     * Notice this method has NO body (no { } code block), just a semicolon.
     * This forces every class that extends Person to write its OWN version
     * of displayDetails(). This is how Java enforces a "contract".
     *
     * This also sets up POLYMORPHISM: later, we can treat different types of
     * Person objects the same way, but each will display its details
     * differently.
     */
    public abstract void displayDetails();
}


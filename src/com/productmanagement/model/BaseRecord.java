package com.productmanagement.model;

public abstract class BaseRecord {

    private int id;

    public BaseRecord(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract void displayDetails();
}
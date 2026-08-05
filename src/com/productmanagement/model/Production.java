package com.productmanagement.model;

/**
 * Production.java
 * ---------------
 * Represents production details for a product:
 * how many units were produced and the current production status.
 */
public class Production {

    private int productionId;
    private int productId;          // links this record to a Product
    private int quantityProduced;
    private String productionStatus; // e.g. "In Progress", "Completed", "On Hold"

    public Production(int productionId, int productId, int quantityProduced,
                      String productionStatus) {
        this.productionId = productionId;
        this.productId = productId;
        this.quantityProduced = quantityProduced;
        this.productionStatus = productionStatus;
    }

    // ---------- Getters and Setters ----------
    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityProduced() {
        return quantityProduced;
    }

    public void setQuantityProduced(int quantityProduced) {
        this.quantityProduced = quantityProduced;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    public void displayProduction() {
        System.out.println("---------------------------------------------------");
        System.out.println("Production ID   : " + productionId);
        System.out.println("Product ID      : " + productId);
        System.out.println("Quantity Made   : " + quantityProduced);
        System.out.println("Status          : " + productionStatus);
    }
}

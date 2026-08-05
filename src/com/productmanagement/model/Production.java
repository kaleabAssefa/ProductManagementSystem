package com.productmanagement.model;

public class Production {

    private int productionId;
    private int productId;
    private int quantityProduced;
    private String productionStatus;

    public Production(int productionId, int productId, int quantityProduced,
                      String productionStatus) {
        this.productionId = productionId;
        this.productId = productId;
        this.quantityProduced = quantityProduced;
        this.productionStatus = productionStatus;
    }
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

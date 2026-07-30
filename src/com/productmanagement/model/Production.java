package com.productmanagement.model;

public class Production extends BaseRecord {

    private Product product;
    private int productionQuantity;
    private String productionStatus;

    public Production(
            int productionId,
            Product product,
            int productionQuantity,
            String productionStatus
    ) {
        super(productionId);
        this.product = product;
        this.productionQuantity = productionQuantity;
        this.productionStatus = productionStatus;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductionQuantity() {
        return productionQuantity;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionQuantity(int productionQuantity) {
        this.productionQuantity = productionQuantity;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------");
        System.out.println("Production ID: " + getId());
        System.out.println("Product ID: " + product.getId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Production Quantity: " + productionQuantity);
        System.out.println("Production Status: " + productionStatus);
    }
}
package com.app.trading.entity;

public class Price {

    private String productName;
    private double numericValue = 0.0;


    public Price(String productName, double numericValue) {
        this.productName = productName;
        this.numericValue = numericValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(double numericValue) {
        this.numericValue = numericValue;
    }
}

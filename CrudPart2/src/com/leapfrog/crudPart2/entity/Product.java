/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.entity;

/**
 *
 * @author chira
 */
public class Product {

    private int productId;
    private String productName, productType, expiryDate, manufacturedDate;

    public Product() {
    }

    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getManufacturedDate(){
        return manufacturedDate;
    }
    public void setManufacturedDate(String manufacturedDate){
        this.manufacturedDate=manufacturedDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}

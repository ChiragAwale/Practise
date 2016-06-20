/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.entity;

/**
 *
 * @author chira
 */
public class Category {
    private Product product;

    public String getProductCategory() {
        return product.getCategory();
    }

    public void setProductCategory(Product product) {
        this.product = product;
    }
    
    
}

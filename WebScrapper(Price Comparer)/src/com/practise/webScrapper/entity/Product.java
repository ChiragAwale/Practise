/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper.entity;

/**
 *
 * @author chira
 */
public class Product {

    private String productName, link, dealer;
    private String price;

    public Product(String productName, String link, String dealer, String price) {
        this.productName = productName;
        this.link = link;
        this.dealer = dealer;
        this.price = price;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", link=" + link + ", dealer=" + dealer + ", price=" + price + '}';
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String website) {
        this.link = website;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

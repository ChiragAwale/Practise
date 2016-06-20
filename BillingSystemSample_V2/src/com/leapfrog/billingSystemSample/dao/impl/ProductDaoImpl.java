/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.dao.impl;

import com.leapfrog.billingSystemSample.dao.ProductDao;
import com.leapfrog.billingSystemSample.entity.Category;
import com.leapfrog.billingSystemSample.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public class ProductDaoImpl implements ProductDao {

    ArrayList<Product> cart = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();

    @Override
    public boolean add(Product p) {
        return productList.add(p);
    }

    @Override
    public ArrayList<Product> showAll() {
        return productList;
    }

    @Override
    public Product getById(int id) {
        for (Product pro : productList) {
            if (id == pro.getProductId()) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public Boolean getByCategory(String category) {
        for (Product pro : productList) {
            if (category.equalsIgnoreCase(pro.getCategory())) {
                System.out.println("Product Id: " + pro.getProductId());
                System.out.println("Product Name: " + pro.getProductName());
                System.out.println("Product Quantity Available: " + pro.getQuantity());
                System.out.println("Product Price: " + pro.getPrice());
                System.out.println("Product Category: " + pro.getCategory());

            }

        }
        return false;
    }

    @Override
    public Boolean getByName(String name) {
        int check = 0;
        for (Product pro : productList) {
            if ((pro.getProductName().contains(name))) {
                System.out.println("Product Id: " + pro.getProductId());
                System.out.println("Product Name: " + pro.getProductName());
                System.out.println("Product Quantity Available: " + pro.getQuantity());
                System.out.println("Product Price: " + pro.getPrice());
                System.out.println("Product Category: " + pro.getCategory());
                check = 1;
            }

        }
        if (check == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkQuantity(int quantity, String name) {
        for (Product prod : productList) {
            if ((quantity) <= prod.getQuantity() && name.equalsIgnoreCase(prod.getProductName())) {

                return true;
            }

        }

        return false;

    }

    @Override
    public boolean addToCart(Product p) {
        return cart.add(p);
    }

    @Override
    public ArrayList<Product> showCart() {
        return cart;
    }

    @Override
    public boolean checkIdForQuantityAndPrice(int id, int quantity, int price) {
        for (Product p : cart) {
            if (p.getProductId() == id) {
                p.setQuantity(p.getQuantity() + quantity);
                p.setPrice(p.getPrice() + price);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean resetCartArray() {
        cart.clear();
        return true;
    }
}

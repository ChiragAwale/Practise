/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.dao;

import com.leapfrog.billingSystemSample.entity.Category;
import com.leapfrog.billingSystemSample.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public interface ProductDao {
    boolean add(Product p);
    ArrayList<Product> showAll();
    ArrayList<Category> showAllCategory();
    Product getById(int id);
    Boolean getByCategory(String category);
    Boolean getByName(String name);
    boolean addCategory(Category c);
    boolean checkCategory(String category);
    boolean checkQuantity(int quantity, String name);
}

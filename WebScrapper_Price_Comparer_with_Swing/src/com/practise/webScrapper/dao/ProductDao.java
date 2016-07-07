/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper.dao;

import com.practise.webScrapper.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public interface ProductDao {

    boolean add(Product p,String search);
    boolean clearArray();
    ArrayList<Product> getAll();
    
}

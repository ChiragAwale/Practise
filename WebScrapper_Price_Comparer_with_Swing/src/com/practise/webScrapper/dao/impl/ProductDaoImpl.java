/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper.dao.impl;

import com.practise.webScrapper.dao.ProductDao;
import com.practise.webScrapper.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public class ProductDaoImpl implements ProductDao {

    ArrayList<Product> productList = new ArrayList<>();

    @Override
    public boolean add(Product p,String search) {
        String searchL = search.toLowerCase().replace("+", " ").replace("-"," ");
        if(p.getProductName().toLowerCase().contains(searchL)){
          
        return productList.add(p);
        }
       
        return false;
    }

    @Override
    public ArrayList<Product> getAll() {
        return productList;

    }

    @Override
    public boolean clearArray() {
        productList.clear();
        return true;
    }

}

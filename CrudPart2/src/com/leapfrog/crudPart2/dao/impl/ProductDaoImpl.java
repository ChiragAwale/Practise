/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.dao.impl;

import com.leapfrog.crudPart2.entity.Product;
import com.leapfrog.crudPart2.dao.ProductDao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class ProductDaoImpl implements ProductDao {

    Scanner ch = new Scanner(System.in);

    private ArrayList<Product> productList = new ArrayList<>();


    @Override
    public boolean insert(Product p) {
        productList.add(p);
        return true;
    }

    @Override
    public Product getById(int id) {
        for (Product prod : productList) {
            if (prod.getProductId() == id) {
                return prod;
            }
        }
        return null;

    }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    @Override
    public ArrayList<Product> getAll() {

        return productList;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean del(int id) {
        Product pro1 = getById(id);
        if (pro1 != null) {
            System.out.println("Do you really want to delete?[y/n]");
            if (ch.next().equalsIgnoreCase("y")) {
                productList.remove(pro1);
            }
            return true;
        } else {
            System.out.println("Entry Not Found. Please Try Again with a Different Id");
            return false;
        }

    }

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    @Override
    public boolean idReset(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastId() {
        int count1 = productList.size();
        if(count1 == 0){
            return 1;
        }
        else { 
           Product pro2 = productList.get(count1 - 1);
           return pro2.getProductId() + 1;
           
        }       
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


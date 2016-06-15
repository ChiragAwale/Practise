/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.dao;

import com.leapfrog.crudPart2.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chirag
 */
public interface ProductDao {

    boolean insert(Product p);

    Product getById(int id);

    boolean del(int id);

    ArrayList<Product> getAll();
   boolean idReset(Product p);
   int getLastId();
}

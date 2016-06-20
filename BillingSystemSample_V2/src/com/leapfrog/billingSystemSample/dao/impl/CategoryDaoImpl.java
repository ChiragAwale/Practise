/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.dao.impl;

import com.leapfrog.billingSystemSample.dao.CategoryDao;
import com.leapfrog.billingSystemSample.entity.Category;
import com.leapfrog.billingSystemSample.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public class CategoryDaoImpl implements CategoryDao {

    ArrayList<Category> categoryList = new ArrayList<>();

    @Override
    public boolean addCategory(Category c) {
        return categoryList.add(c);
    }

    @Override
    public boolean checkCategory(String category) {

        for (Category cat : categoryList) {
            if (cat.getProductCategory().equals(category)) {
                return true;
            }

        }

        return false;

    }

    @Override
    public ArrayList<Category> showAllCategory() {
        return categoryList;
    }
}

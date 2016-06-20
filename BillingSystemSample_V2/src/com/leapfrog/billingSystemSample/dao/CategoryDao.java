/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.dao;

import com.leapfrog.billingSystemSample.entity.Category;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public interface CategoryDao {

    ArrayList<Category> showAllCategory();

    boolean addCategory(Category c);

    boolean checkCategory(String category);
}

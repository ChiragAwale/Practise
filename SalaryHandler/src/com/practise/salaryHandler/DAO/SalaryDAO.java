/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.salaryHandler.DAO;

import com.practise.salaryHandler.entity.Salary;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public interface SalaryDAO {
public void insert(Salary salary);
ArrayList<Salary> getAll();
public void delete(String name);
}

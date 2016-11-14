/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.salaryHandler.DAO.impl;

import com.practise.salaryHandler.DAO.SalaryDAO;
import com.practise.salaryHandler.entity.Salary;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public class SalaryDAOImpl implements SalaryDAO {
ArrayList salaryList = new ArrayList<>();

    @Override
    public void insert(Salary salary) {
     salaryList.add(salary);
     }
    
    @Override
    public ArrayList<Salary> getAll(){
        return salaryList;
    }
    
    @Override
    public void delete(String name){
        Salary slry = new Salary();
      for(Salary s : getAll()){
          if(s.getName().equalsIgnoreCase(name)){
             slry = s;
              break;
          }
          
      }  
      salaryList.remove(slry);
        
    }
    
}

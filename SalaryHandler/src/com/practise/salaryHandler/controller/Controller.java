/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.salaryHandler.controller;

import com.practise.salaryHandler.DAO.SalaryDAO;
import com.practise.salaryHandler.DAO.impl.SalaryDAOImpl;
import com.practise.salaryHandler.entity.Salary;
import java.util.Scanner;
/**
 *
 * @author chira
 */
public class Controller {

    SalaryDAO salaryDAO = new SalaryDAOImpl();
    Scanner input = new Scanner(System.in);   
    public void insert() {
     

        Salary salary = new Salary();
        System.out.println("Enter Name of the employee");
        salary.setName(input.next());

        System.out.println("Enter Salary");
        double amount = input.nextInt();
        salary.setAmount(amount);
        salary.setTax((amount * 9) / 100);

        salaryDAO.insert(salary);

    }
    
    public void getAll()
    {
        for(Salary s : salaryDAO.getAll())
        {
            System.out.println("Name: "+s.getName());
            System.out.println("Salary: "+s.getAmount());
            System.out.println("Tax: "+s.getTax());
            
        }
        
        
        
    }
    
    public void delete(){
   
        System.out.println("Enter name you want to delete");
        salaryDAO.delete(input.next());
        
    }
}

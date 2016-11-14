/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.salaryHandler;

import com.practise.salaryHandler.DAO.SalaryDAO;
import com.practise.salaryHandler.DAO.impl.SalaryDAOImpl;
import com.practise.salaryHandler.entity.Salary;
import java.util.Scanner;
import com.practise.salaryHandler.controller.Controller;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
            menu();
            switch (input.nextInt()) {
                case 1:
                    controller.insert();
                    System.out.println("Do you want to exit? [y/n]");
                    if (input.next().equalsIgnoreCase("y")) {
                        break;
                    }
                    break;
                case 2:
                   controller.delete();
                    break;
                case 3:
                    controller.getAll();
                    System.out.println("Do you want to exit? [y/n]");
                    if (input.next().equalsIgnoreCase("y")) {
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Welcome to the Salary Calculator");
        System.out.println("What do you want to do? ");
        System.out.println("1.Add Entry");
        System.out.println("2.Delete Entry");
        System.out.println("3.View All Entries");
    }

}

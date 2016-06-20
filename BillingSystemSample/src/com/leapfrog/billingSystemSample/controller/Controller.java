/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.controller;

import com.leapfrog.billingSystemSample.dao.ProductDao;
import com.leapfrog.billingSystemSample.dao.impl.ProductDaoImpl;
import com.leapfrog.billingSystemSample.entity.Product;
import com.leapfrog.billingSystemSample.entity.Category;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Controller {

    Scanner input = new Scanner(System.in);

    ProductDao productDao = new ProductDaoImpl();

    public void add() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\Practise\\BillingSystemSample\\Data.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Product product = new Product();
                Category category = new Category();
                product.setProductId(Integer.parseInt(tokens[0]));
                product.setProductName(tokens[1]);
                product.setQuantity(Integer.parseInt(tokens[2]));
                product.setPrice(Integer.parseInt(tokens[3]));
                product.setCategory(tokens[4]);
                category.setProductCategory(product);
                productDao.add(product);
                if (productDao.checkCategory(tokens[4]) == false) {
                    productDao.addCategory(category);
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void show() {
        for (Product pro : productDao.showAll()) {
            System.out.println(pro.getProductId()
                    + pro.getProductName()
                    + pro.getQuantity()
                    + pro.getPrice()
                    + pro.getCategory());
        }
    }

    public void menu() {
        try{
        while (true) {
            System.out.println("Welcome to Sample Billing System");
            System.out.println("You want to search by: ?");
            System.out.println("1.Id");
            System.out.println("2.Category");
            System.out.println("3.Name");
            System.out.println("4.Exit");
            System.out.println("You can choose from [1-4]:");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    id();
                    break;
                case 2:
                    category();
                    break;
                case 3:
                    name();
                    break;
                case 4:
                    System.out.println("Thank you. Please Visit Again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Entry Try again");
                    break;
            }
        }
        }catch(InputMismatchException ime){
           System.out.println(ime.getMessage() + "Invalid id, Please Try Again");
          
       }
        
    }

    public void id() {
       
        try{
        while (true) {
            System.out.println("Enter Id of the Product");
            int idQuery = input.nextInt();
            Product print = productDao.getById(idQuery);
            System.out.println("Product Id: " + print.getProductId());
            System.out.println("Product Name: " + print.getProductName());
            System.out.println("Product Quantity Available: " + print.getQuantity());
            System.out.println("Product Price: " + print.getPrice());
            System.out.println("Product Category: " + print.getCategory());
            buy();

            System.out.println("Do you want to try  searching by id again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
       }catch(NullPointerException no){
           System.out.println("Invalid id, Enter Try Again");
           
       }
       

    }

    public void category() {
        while (true) {
            System.out.println("Enter Category you want to search");
            System.out.println("The available categories are: ");
            for (Category cat : productDao.showAllCategory()) {

                System.out.println(cat.getProductCategory());

            }
            System.out.println("Enter category you want to search");
            String categoryQuery = input.next();
            productDao.getByCategory(categoryQuery);

            buy();
            System.out.println("Do you want to try searching buy category again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void name() {
        while (true) {

            System.out.println("Enter Name you want to search");

            String nameQuery = input.next();
            if((productDao.getByName(nameQuery))==false){
                System.out.println("No entries found please try again");
            }
            
            buy();
            System.out.println("Do you want to try searching by name again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    public void buy() {
        System.out.println("Enter Product Id if you want to buy");
        System.out.println("(Enter 0 to goto main menu)");

        int choice = input.nextInt();

        while (true) {
            int quit = 0;
            if (choice == 0) {
                break;
            }

            System.out.println("Enter Quantity.(Enter 0 to goto main menu)");
            int choiceQuantity = input.nextInt();
            if (choiceQuantity == 0) {
                break;
            }

            for (Product p : productDao.showAll()) {
                if (choice == p.getProductId()) {
                    if (productDao.checkQuantity(choiceQuantity, p.getProductName()) == true) {
                        int amount = (p.getPrice() * choiceQuantity);
                        System.out.println("Are you sure you want to buy " + choiceQuantity + " " + p.getProductName() + "(s) for " + amount + " ?[y/n]");

                        if (input.next().equalsIgnoreCase("n")) {
                            break;
                        } else {

                            System.out.println("The total cost would be " + amount);
                            System.out.println("Enter amount you have paid ");
                            int change = input.nextInt();
                            if (amount <= change) {
                                System.out.println("Here you go. Your payment has been confirmed");
                                System.out.println("Your change is " + (change - amount));
                                p.setQuantity((p.getQuantity() - choiceQuantity));
                                System.out.println("Do you want to buy more " + p.getProductName() + "(s) ??[y/n]");
                                if (input.next().equalsIgnoreCase("n")) {
                                    quit = 1;
                                    break;
                                }
                            } else {
                                quit = 1;
                                System.out.println("Amount insufficient. Please try again");

                            }

                            break;
                        }
                    } else {
                        System.out.println("Quantity not available,Please try a little less");
                    }

                    if (quit == 1) {
                        break;
                    }
                }
            }
            if (quit == 1) {
                break;
            }

        }
    }
}

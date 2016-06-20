/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample.controller;

import com.leapfrog.billingSystemSample.dao.CategoryDao;
import com.leapfrog.billingSystemSample.dao.ProductDao;
import com.leapfrog.billingSystemSample.dao.impl.CategoryDaoImpl;
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
    CategoryDao categoryDao = new CategoryDaoImpl();
    int total = 0;

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
                if (categoryDao.checkCategory(tokens[4]) == false) {
                    categoryDao.addCategory(category);
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void menu() {
        try {
            while (true) {
                System.out.println("Welcome to Sample Billing System Version 2");
                System.out.println("You want to search by: ?");
                System.out.println("1.Id");
                System.out.println("2.Category");
                System.out.println("3.Name");
                System.out.println("4.Show Cart");
                System.out.println("5.Exit");
                System.out.println("You can choose from [1-5]:");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        searchById();
                        break;
                    case 2:
                        searchByCategory();
                        break;
                    case 3:
                        searchByName();
                        break;
                    case 4:
                        showCart();
                        break;
                    case 5:
                        System.out.println("Thank you. Please Visit Again");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Entry Try again");
                        break;
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage() + "Invalid id, Please Try Again");

        }

    }

    public void searchById() {

        try {
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
        } catch (NullPointerException no) {
            System.out.println("Invalid id, Enter Try Again");

        }

    }

    public void searchByCategory() {
        while (true) {
            System.out.println("Enter Category you want to search");
            System.out.println("The available categories are: ");
            for (Category cat : categoryDao.showAllCategory()) {

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

    public void searchByName() {
        while (true) {

            System.out.println("Enter Name you want to search");

            String nameQuery = input.next();
            if ((productDao.getByName(nameQuery)) == false) {
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

            if (choice == 0) {
                break;
            }

            System.out.println("Enter Quantity to add more to cart (Enter 0 to goto main menu)");
            int choiceQuantity = input.nextInt();
            if (choiceQuantity == 0) {
                break;
            }

            for (Product p : productDao.showAll()) {
                if (choice == p.getProductId()) {
                    if (productDao.checkQuantity(choiceQuantity, p.getProductName()) == true) {
                        int amount = (p.getPrice() * choiceQuantity);
                        System.out.println("Are you sure you want to add " + choiceQuantity + " " + p.getProductName() + "(s) for " + amount + " to cart?[y/n]");

                        if (input.next().equalsIgnoreCase("n")) {
                            break;
                        } else {
                            p.setQuantity(p.getQuantity() - choiceQuantity);
                            Product procart = new Product();
                            procart.setProductId(p.getProductId());
                            procart.setProductName(p.getProductName());
                            procart.setQuantity(choiceQuantity);
                            procart.setPrice(amount);
                            procart.setCategory(p.getCategory());
                            if (productDao.checkIdForQuantityAndPrice(p.getProductId(), choiceQuantity, amount) == false) {

                                productDao.addToCart(procart);
                            }

                            break;
                        }
                    } else {
                        System.out.println("Quantity not available,Please try a little less");
                    }

                }
            }

        }
    }

    public void checkOut() {
        while (true) {
            System.out.println("Enter money given ");
            int money = input.nextInt();
            if (money < total) {
                System.out.println("Money not enough. Please enter valid amount");
            } else {
                System.out.println("Here is the change: " + (money - total));
                productDao.resetCartArray();
                System.out.println("Press Any Key to Goto Main menu");
                input.next();

                break;
            }
        }
    }

    public void showCart() {
        total = 0;
        for (Product p : productDao.showCart()) {
            System.out.println("Product Id: " + p.getProductId());
            System.out.println("Product Name: " + p.getProductName());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Total Price: " + p.getPrice());
            total = total + p.getPrice();
            System.out.println("Product Category: " + p.getCategory());
        }
        System.out.println("You Total is: " + total);
        System.out.println("Do you want to check out?[y/n]");
        if (input.next().equalsIgnoreCase("y")) {
            checkOut();
        }
    }
}

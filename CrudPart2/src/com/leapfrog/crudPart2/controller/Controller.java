/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.controller;

import com.leapfrog.crudPart2.dao.ProductDao;
import com.leapfrog.crudPart2.dao.impl.ProductDaoImpl;
import com.leapfrog.crudPart2.entity.Product;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Controller {

    Scanner input;
    ProductDao productDAO = new ProductDaoImpl();
    int id;

    public Controller(Scanner input) {
        this.input = input;

    }

    public void menu() {
        System.out.println(" Welcome to ABC department Store");
        System.out.println("1. Add product");
        System.out.println("2. Search Product by Id");
        System.out.println("3. Show All Records");
        System.out.println("4. Delete Records");
        System.out.println("5. Exit");
        System.out.println("Enter Choice [1-5]");

    }

    public void add() {
        while (true) {
            Product info = new Product();
            info.setProductId(productDAO.getLastId());
            System.out.println("Enter Name");
            info.setProductName(input.next());
            System.out.println("Enter Type");
            info.setProductType(input.next());
            System.out.println("Enter Manufactured Date");
            info.setManufacturedDate(input.next());
            System.out.println("Enter Expiry Date");
            info.setExpiryDate(input.next());
            productDAO.insert(info);

            System.out.println("Do you want to go to main menu[y/n]");
            if (input.next().equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void showAll() {
        for (Product prod : productDAO.getAll()) {
            System.out.println("Product Id: " + prod.getProductId());
            System.out.println(" Product Name: " + prod.getProductName());
            System.out.println(" Product Type: " + prod.getProductType());
            System.out.println(" Product Expiry Date: " + prod.getExpiryDate());
            System.out.println(" Product Manufactured Date: " + prod.getManufacturedDate());
        }
        System.out.println(" Press any key to go to main menu");
        input.next();

    }

    public void delete() {
        while (true) {
            System.out.println("Enter Product Id you want to delete");
            int del = input.nextInt();
            productDAO.del(del);
            
            System.out.println("Do you want to delete more[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void getByID() {
        while (true) {
            System.out.println("Enter Id you want to search");

            Product prod = productDAO.getById(input.nextInt());
            if (prod != null) {
                System.out.println("Id: " + prod.getProductId());
                System.out.println("Product Name " + prod.getProductName());
                System.out.println("Product Type " + prod.getProductType());
                System.out.println("Product Manufacture Date " + prod.getManufacturedDate());
                System.out.println("Product Expiry Date " + prod.getExpiryDate());
            } else {
                System.out.println("Id not found");
            }
            System.out.println("Do you want to search again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void process() {
        menu();
        switch (input.nextInt()) {
            case 1:
                add();
                break;
            case 2:
                getByID();
                break;
            case 3:
                showAll();
                break;
            case 4:
                delete();
                break;
            case 5:
                System.out.println("Do you really want to exit?[y/n]");
                if (input.next().equalsIgnoreCase("y")) {
                    System.exit(0);
                }

                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }
    }
}

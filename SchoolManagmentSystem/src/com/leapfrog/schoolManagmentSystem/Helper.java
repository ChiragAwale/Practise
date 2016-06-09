/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.schoolManagmentSystem;

import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Helper {

    String[] names = new String[10];
    String temp;
    int counter = 0;
    int counter1 = 0;
    int i;
    int length = names.length;
    int z;
    Scanner input;
  
    public Helper(Scanner input) {
        this.input = input;
    }

    public void menu() {
        System.out.println("Welcome to School Managagement System");
        System.out.println("1.Add");
        System.out.println("2.Delete");
        System.out.println("3.Search");
        System.out.println("4.Show All");
        System.out.println("5.Exit");
        System.out.println("Enter your choice[1-5]");
    }

    public void add() {
        while (true) {
            if(counter==10){
                System.out.println("Out of memory, delete some records!!");
                break;
            }
            System.out.println("Enter Name you want to add");
            names[counter] = input.next();
            counter++;
            System.out.println("You can add " + (length - counter) + " more records");
            System.out.println("Do you want to add more?[y/n]");
            String quiter = input.next();
            if (quiter.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAll() {
        if(counter==0){
            System.out.println("No entries to show");
        }
        for (i = 0; i < 10; i++) {
            if (names[i] != null && names[i] != "null") {
                System.out.println(names[i]);
            }

        }

    }

    public void search() {
        while (true) {
            System.out.println("Enter Text you want to search");
            String search = input.next();
            for (i = 0; i < counter; i++) {
                if (names[i].contains(search)) {
                    System.out.println(names[i]);
                }

            }
            System.out.println("Do you want to search again?[y/n]");
            String quiter = input.next();
            if (quiter.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void delete() {
        while(true){
        counter1 = 0;
            System.out.println("You can delete from the following records");
        showAll();
        System.out.println("Which name you want to delete?");
        String delete = input.next();
        for (i = 0; i < 10; i++) {
            if (delete.equals(names[i])) {
                System.out.println(names[i] + " has been deleted");
                names[i] = null;
                counter = counter - 1;
                counter1 = 1;
                break;
                
            }
            
        }
        if(counter1!=1){
            System.out.println("No records found to delete");
        }
         
         System.out.println("Delete Another?[y/n]");
            if(input.next().equalsIgnoreCase("n")){
                break;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataBase;
import java.util.Scanner;
import com.leapfrog.dataBase.parts.Cosmetics;
import com.leapfrog.dataBase.parts.Beverages;
import com.leapfrog.dataBase.parts.Delivery;
import com.leapfrog.dataBase.parts.It;
/**
 *
 * @author chira
 */
public class Center {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
            System.out.println("The ABC company");;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Cosmetics Department");
        System.out.println("2.Beverages Department");
        System.out.println("3.Delivery Department");
        System.out.println("4.It Department");
        System.out.println("Choose the department you want to view/set data of/for]1-10]");
        int choice = scanner.nextInt();
        
        switch(choice){
            case 1: 
                Cosmetics();
                break;
            case 2:   
                Beverages();
                break;
            case 3:
                Delivery();
                break;
            case 4:
                It();
                break;
            default:
                System.exit(0);
                break;
        
        }
        }
    } 
    public static void Cosmetics(){
        Scanner scanner = new Scanner(System.in);
        Cosmetics cosmetics = new Cosmetics();
            System.out.println("View or Set Records?[1,2]");
            int choice1 = scanner.nextInt();
            if(choice1==2){
                System.out.println("Enter Product");
                cosmetics.setProduct(scanner.next());
                System.out.println("Enter Type");
                cosmetics.setType(scanner.next());
                System.out.println("Enter Use");
                cosmetics.setUse(scanner.next());
                System.out.println("Enter Manufactured Date[dd/mm/yy]");
                cosmetics.setManufacturedDate(scanner.next());
                System.out.println("Enter Expiry Date[dd/mm/yy]");
                cosmetics.setExpiryDate(scanner.next());
                
                System.out.println("Product: " + " " + cosmetics.getProduct());
                System.out.println("Type: " + " " + cosmetics.getType());
                System.out.println("Use: " + " " + cosmetics.getUse());
                System.out.println("Manufactured Date: " + " " + cosmetics.getManufacturedDate());
                System.out.println("Product: " + " " + cosmetics.getExpiryDate());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
 
                
            }
            else {   
               cosmetics.setProduct("Whiteneing Cream");
               cosmetics.setType("Cream");
               cosmetics.setUse("Mosturizer + Whitener");
               cosmetics.setManufacturedDate("11/5/2010");
               cosmetics.setExpiryDate("11/5/2017");
               System.out.println("Product: " + " " + cosmetics.getProduct());
                System.out.println("Type: " + " " + cosmetics.getType());
                System.out.println("Use: " + " " + cosmetics.getUse());
                System.out.println("Manufactured Date: " + " " + cosmetics.getManufacturedDate());
                System.out.println("Expiry Date: " + " " + cosmetics.getExpiryDate());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
            } 
    }
    public static void Beverages(){
    Scanner scanner = new Scanner(System.in);
        Beverages beverages = new Beverages();
            System.out.println("View or Set Records?[1,2]");
            int choice1 = scanner.nextInt();
            if(choice1==2){
                System.out.println("Enter Name");
                beverages.setName(scanner.next());
                System.out.println("Enter Quantity Per Bottle");
                beverages.setQuantityPerBottle(scanner.next());
                System.out.println("Enter Price");
                beverages.setPrice(scanner.next());
                System.out.println("Enter Manufactured Date[dd/mm/yy]");
                beverages.setManufacturedDate(scanner.next());
                System.out.println("Enter Expiry Date[dd/mm/yy]");
                beverages.setExpiryDate(scanner.next());
                
                System.out.println("Name: " + " " + beverages.getName());
                System.out.println("Quantity Per Bottle: " + " " + beverages.getQuantityPerBottle());
                System.out.println("Price: " + " " + beverages.getPrice());
                System.out.println("Manufactured Date: " + " " + beverages.getManufacturedDate());
                System.out.println("Expiry Date: " + " " + beverages.getExpiryDate());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
            }
            else {   
               beverages.setName("Cococol");
               beverages.setQuantityPerBottle("500ml");
               beverages.setPrice("50");
               beverages.setManufacturedDate("11/5/2010");
               beverages.setExpiryDate("11/5/2017");
               System.out.println("Name: " + " " + beverages.getName());
                System.out.println("Quantity Per Bottle: " + " " + beverages.getQuantityPerBottle());
                System.out.println("Price: " + " " + beverages.getPrice());
                System.out.println("Manufactured Date: " + " " + beverages.getManufacturedDate());
                System.out.println("Product: " + " " + beverages.getExpiryDate());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
            } 
    }
    public static void Delivery(){
        Scanner scanner = new Scanner(System.in);
        Delivery delivery = new Delivery();
            System.out.println("View or Set Records?[1,2]");
            int choice1 = scanner.nextInt();
            if(choice1==2){
                System.out.println("Enter No Of Vehicles");
                delivery.setNoOfVehicles(scanner.nextInt());
                System.out.println("No Of Outlets");
                delivery.setNoOfOutlets(scanner.nextInt());
                System.out.println("Enter Price");
                delivery.setPrice(scanner.nextInt());
            
                
                System.out.println("No Of Vehicles: " + " " + delivery.getNoOfVehicles());
                System.out.println("No Of Outlets: " + " " + delivery.getNoOfOutlets());
                System.out.println("Price: " + " " + delivery.getPrice());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
               
            }
            else {   
               delivery.setNoOfVehicles(50);
               delivery.setNoOfOutlets(25);
               delivery.setPrice(500);
               
               System.out.println("Name: " + " " + delivery.getNoOfVehicles());
                System.out.println("Quantity Per Bottle: " + " " + delivery.getNoOfOutlets());
                System.out.println("Price: " + " " + delivery.getPrice());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
             
            } 
    }
    public static void It(){
        Scanner scanner = new Scanner(System.in);
        It it = new It();
            System.out.println("View or Set Records?[1,2]");
            int choice1 = scanner.nextInt();
            if(choice1==2){
                System.out.println("Enter No Of Workers");
                it.setNoOfWorkers(scanner.nextInt());
                System.out.println("Expense per month in dollars");
                it.setTotalExpensePerMonth(scanner.nextInt());
                System.out.println("Enter Total Budget in dollars");
                it.setTotalBudget(scanner.nextInt());
                System.out.println("Enter Status");
                it.setStatus(scanner.next());
                
            
                
                System.out.println("No Of Workers: " + " " + it.getNoOfWorkers());
                System.out.println("Expense per month in dollars: " + " " + it.getTotalExpensePerMonth());
                System.out.println("Total Budget in dollars: " + " " + it.getTotalBudget());
                System.out.println("Status: " + " " + it.getStatus());
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
            }
            else {   
               it.setNoOfWorkers(502);
               it.setTotalExpensePerMonth(2500);
               it.setTotalBudget(50000);
               it.setStatus("Available");
               
               System.out.println("No of Workers: " + " " + it.getNoOfWorkers());
                System.out.println("Expense Per month in Dollars: " + " " + it.getTotalExpensePerMonth());
                System.out.println("Total Budget in Dollars: " + " " + it.getTotalBudget());
                System.out.println("Status:" + " " + it.getStatus() );
                
                System.out.println("");
                System.out.println("Want to go back to main menu again?[y/n]");
                if (scanner.next().equalsIgnoreCase("n")){
                    System.exit(0);
                }
    
        
    }
}   
}    
    


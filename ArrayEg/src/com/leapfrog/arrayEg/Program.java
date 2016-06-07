/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.arrayEg;
import java.util.Scanner;

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
   
   String [] subjects = {"Math", "English", "Physics", "Chemistry", "Nepali"};
   Marksheet ms = new Marksheet(subjects,input);

   ms.getMarks();
   ms.checkfail();
   
        if (!ms.checkfail()){ 
        ms.getPercentage();
        ms.getDivision();
        }
        else {
            System.out.println("You have failed.");
        }
       
        
           
  
       
    }
    
}

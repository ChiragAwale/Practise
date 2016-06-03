/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.firstDay;

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
       Scanner input = new Scanner(System.in)  ; 
//Marksheet without Input 
       String name = "Ram";
       String symbol = "1123312y";
       String grade = "";
       double cmath = 89, optmath = 98, nep = 75, eng = 78, sc = 80, pe = 0;
       
       if (cmath < 32 || optmath < 32 || nep < 32 || eng < 32 || sc < 32){
           System.out.println("You Failed"); 
         }
       else { 
          pe = (( cmath + optmath + sc + eng + nep)*100)/500;
        if (pe >= 80){ grade = "You scored a Distinction";
        }
        else if (pe >= 60 && pe <80) { grade = "You Scored First Division";
        } 
        else if (pe >= 40 && pe < 60){  grade = "You Scored Second Division";
        }
        else if (pe <40){  grade = "You failed";
        }
           System.out.println("Your percentage is "+ pe);
           System.out.println(grade);
    
      }
       //Marksheet with Input
       System.out.println("Enter Your Name");
       String name1 = input.next();
        
       System.out.println("Enter Symbol No");
       String symbol1 = input.next();
       
        String grade1 = "";
        System.out.println("Enter Cmath Marks");
        double cmath1 = input.nextDouble();
        System.out.println("Enter Optional Maths Marks"); 
        double optmath1 = input.nextDouble();
        System.out.println("Enter Nepali Marks");
        double nep1 = input.nextDouble();
        System.out.println("Enter English Marks");
        double eng1 = input.nextDouble();
        System.out.println(" Enter Science Marks");
        double sc1 = input.nextDouble();
       
        double pe1 = 0;
       
       if (cmath1 < 32 || optmath1 < 32 || nep1 < 32 || eng1 < 32 || sc1 < 32){
           System.out.println("You Failed"); 
         }
       else { 
          pe1 = (( cmath + optmath + sc + eng + nep)*100)/500;
        if (pe1 >= 80){ grade1 = "You scored a Distinction";
        }
        else if (pe1 >= 60 && pe <80) { grade1 = "You Scored First Division";
        } 
        else if (pe1 >= 40 && pe < 60){  grade1 = "You Scored Second Division";
        }
        else if (pe1 <40){  grade1 = "You failed";
        }
           System.out.println("Your percentage is "+ pe1);
           System.out.println( grade1);
    
      }
      //Print 1 to 100
     
       for(int i = 1; i <=100; i++){
       System.out.println(i);
       }
    //Print tables with input
        System.out.println("Enter No");
    int num = input.nextInt();
     for (int z = 1;z<=10 ;z++){
        System.out.println(num + "*" + z + "=" + num*z);
    }
    //Print tables with input and continue
        while(true){
     System.out.println("Enter No");
   
       int num1 = input.nextInt();
   
    for (int z = 1;z<=10 ;z++){
        System.out.println(num1 + "*" + z + "=" + num*z);
    }
            System.out.println("Do you want to continue?[Y/N]");
            String choice = input.next();
            if (choice.equalsIgnoreCase("n")){
                System.exit(0);
               
                
            }
        }
      
        
      
    }
    }

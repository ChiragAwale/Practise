/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.calculatorVer1;

import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // Calculator
        Scanner input = new Scanner(System.in);
        while(true){
        System.out.println("Enter First Number(a)");
        double first = input.nextDouble();
        
        System.out.println("Enter Second Number(b)");
        double second = input.nextDouble();
        
        System.out.println("1.Add");
        System.out.println("2.Sub");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");
        System.out.println("5.Power");
        System.out.println("6.Exit");
    
        System.out.println("What do you want to do choose [1-6]");
        int z = input.nextInt();
        if(z==1){
            System.out.println("The sum is = " + (first+second));
        }
        else if (z==2){
            System.out.println("1.a - b or 2.b - a?[1/2]");
            int sub1 = input.nextInt();
            if (sub1==1){ System.out.println("The result is " + (first-second));}
            else {System.out.println(" The result is " + (second-first));
            }
        }
            else if (z==3){
                    System.out.println("The result is " + (second*first));
            }
            else if (z==4){
                   System.out.println("1.a/b or 2.b/a?[1/2]");
            int div1 = input.nextInt();
            if (div1==1){ System.out.println("The result is " + (first/second));}
            else {System.out.println(" The result is " + (second/first));
        }
            }
            else if (z==5){
                       System.out.println("1.a^b or 2.b^a?[1/2]");
            int pwr1 = input.nextInt();
            if (pwr1==1){ System.out.println("The result is " + Math.pow(first,second));}
            else {System.out.println(" The result is " + Math.pow(second,first));
                    }
            }
            else if (z==6){
               System.exit(0);
            }
        System.out.println("Do you want to continue?[y/n]");
        String choice = input.next();
            if (choice.equalsIgnoreCase("n")){
                System.exit(0);
            }
    }  
}
}
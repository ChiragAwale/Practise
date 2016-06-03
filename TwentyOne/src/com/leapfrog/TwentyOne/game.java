/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.TwentyOne;
import java.util.Scanner;
/**
 *
 * @author chira
 */
public class game {

    public static void menu(){
        System.out.println("Twenty One");
        System.out.println("Here are the rules");
        System.out.println("1.You can add upto 3 per turn. The one that Lands on 21 looses");
        System.out.println("You want to go first?[Y/N]");
    }
 
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        menu();
        String c = input.next();
        if (c.equalsIgnoreCase("n")){
            System.out.println(z);
        }
           
       
        
        
        
       
        
        
    }
    
}

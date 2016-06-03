/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.calculatorver2;
import java.util.Scanner;
import com.leapfrog.calculatorver2.util.Calculation;
/**
 *
 * @author chira
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void menu(){
        System.out.println("1.Add");
        System.out.println("2.Sub");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");
        System.out.println("5.Power");
        System.out.println("6.Exit");
        System.out.println("What do you want to do choose  [1-6]");
    }
    public static void main(String[] args) {
   // Calculator
        Scanner input = new Scanner(System.in);
        while(true){
        System.out.println("Enter First Number(a)");
        int x = input.nextInt();
        
        System.out.println("Enter Second Number(b)");
        int y = input.nextInt();
        
        
    
        menu();
        
        int z = input.nextInt();
        
        int totals = Calcu(z, x, y);
            System.out.println("Your Result is " + totals );
        System.out.println("Do you want to continue?[y/n]");
        String choice = input.next();
            if (choice.equalsIgnoreCase("n")){
                System.exit(0);
            }
    }  
}
private static int Calcu(int z, int x, int y){
    Calculation zxc = new Calculation();
   
    int total = 0;
    switch(z){
        case 1:
            total =zxc.add(x,y);
          break;
        case 2:
            total =zxc.sub(x,y);
            break;
        case 3:
            total =zxc.mul(x,y);
            break;
        case 4:
            total =zxc.division(x,y);
            break;
        case 5:
            total =zxc.pwr(x,y);
            break;
        case 6:
            System.exit(0);
            break;
        default:
            System.exit(0);
            break;
    }
    return total;
    }
}


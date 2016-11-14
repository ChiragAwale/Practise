
package com.practise.amalgamatedArtichokes;
import java.util.Scanner;

/**
 *
 * @author chirag
 */
//This program calculates the maximum decline in stock prices
public class Program {

    public static void main(String[] args) {
        int a, b, c, d, n, p, k;
        double price, checker, decline, maxDecline = 0;
        
        Scanner input = new Scanner(System.in);
        
        //Asks the user for 6 values and stores them in respective variables according to their position
        System.out.println("Enter 6 integers separated by a space");
        p = input.nextInt();
        while (!(p >= 1 && p <= 1000)) {                                                           //Used for input validation
            System.out.println("The first value should be between 1 to 1000, Please enter again");
            p = input.nextInt();
        }
        a = input.nextInt();                                                                
        while (!(a >= 0 && a <= 1000)) {                                                           //Used for input validation
            System.out.println("The second value should be between 0 to 1000, Please enter again");
            a = input.nextInt();
        }
        b = input.nextInt();                                                                     
        while (!(b >= 0 && b <= 1000)) {                                                           //Used for input validation
            System.out.println("The third value should be between 0 to 1000, Please enter again");
            b = input.nextInt();
        }
        c = input.nextInt();
        while (!(c >= 0 && c <= 1000)) {                                                           //Used for input validation
            System.out.println("The fourth value should be between 0 to 1000, Please enter again");
            c = input.nextInt();
        }
        d = input.nextInt();
        while (!(d >= 1 && d <= 1000)) {                                                           //Used for input validation
            System.out.println("The fifth value should be between 0 to 1000, Please enter again");
            d = input.nextInt();
        }
        n = input.nextInt();
        while (!(n >= 1 && n <= 1000000)) {                                                        //Used for input validation
            System.out.println("The last value should be between 1 to 1000000, Please enter again");
            n = input.nextInt();
        }

        

       
        checker = (p * (Math.sin(a * 1 + b) + Math.cos(c * 1 + d) + 2));                           //Used for comparison(Formula is for calculating stock decline)
       
        for (k = 1; k <= n; k++) {

            price = (p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2));                         //price changes according to value of k
            if (price < checker) { 
                decline = checker - price;
                if (decline >= maxDecline) {
                    maxDecline = decline;                                                          //Only the highest decline is stored after comparison
                }

            } else if (price > checker) {                                                          //The highest price is stored(Used for calcluation of highest decline)
                checker = price;
            }

        }  
        System.out.println(maxDecline);                                                            //Result

    }

}

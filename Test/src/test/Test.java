/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double price,checker,decline=10000, maxDecline = 0;
        
    
      
        price = 0;
        checker = 0;
        for (int k = 1; k <= 10 ; k++) {
           
            price = price = (42 * (Math.sin(1 * k + 23) + Math.cos(4 * k + 8) + 2));
            
           if(price<checker)
           {
              decline = checker - price; 
              if(decline >= maxDecline)
              {
                  maxDecline = decline;
              }
              
           }else if (price > checker)
           {
               checker = price;
           }
          
            
        
        }   // TODO code application logic here
        System.out.println(maxDecline);
    }
    
}

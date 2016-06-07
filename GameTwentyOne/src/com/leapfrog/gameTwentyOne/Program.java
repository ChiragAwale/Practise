/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.gameTwentyOne;
import java.util.Random;
import java.util.Scanner;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     Scanner scanner = new Scanner(System.in);

        System.out.println("Twenty One--Beta");
        System.out.println("Here are the rules:");
        System.out.println("1.You can add upto 3 at a time");
        System.out.println("2.The player who goes first starts from 1");
        System.out.println("The player that lands on 21 looses");
        while(true){
        System.out.println("Do you want to go first??");
        if (scanner.next().equalsIgnoreCase("Y")){
            Yes();   
        }  
        else {
            No(); 
        }
            
        }
        
    }
    

    public static void Quit(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Thank you for playing..type Q to quit");
                   if (scanner.next().equalsIgnoreCase("q")){
                    System.exit(0);
    }
}
    public static void Yes(){
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        int random = ran.nextInt(3)+1;
       
        
        System.out.println("Okay!");
            System.out.println("Enter either 1, 2 or 3 for your first turn");
            int player = scanner.nextInt();
            
            int num = random + player;
            System.out.println(num);
            game(num);
            
            
               }
    public static void No(){
        Random ran = new Random();
        int random = ran.nextInt(3)+1;
        System.out.println("Okay!");
        
            
           int num = random;
           System.out.println("I choose" + num);
           
           game(num);
              
            
               }
    
    
    public static void game(int num){
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
       
        
        
        int i;
            for(i = num;i<=21;){
               if((i+1)==21){

               System.out.println("Enter...You can choose [" + (i+1)+ "]");
               int player1 = scanner.nextInt();
                   System.out.println("You choose " + player1);
                   System.out.println("You Loose,Better luck next time");
                   Quit();
               
               }
               if((i+2)==21){

               System.out.println("Enter...You can choose [" + (i+1) + "," + (i+2) +"," + "]");
               int player1 = scanner.nextInt();
               if (player1==21) {
                             System.out.println("You loose");
                             Quit();
                             }
               else{

                     System.out.println("I loose");
                     Quit();
                 }
                 
                
              
                 
                     
                 }
               
               if((i+3)==21 ){

               System.out.println("Enter...You can choose [" + (i+1) + "," + (i+2) +"," +(i+3) + "]");
               int player1 = scanner.nextInt();
               
               int comp = (ran.nextInt((21-player1))+1) + player1;
               System.out.println("I choose " + comp);
               if(comp == 21){
                     System.out.println("I loose");
                     Quit();
                 }
                 else if(player1 == 21){
                     System.out.println("You Loose");
                     Quit();
               i = comp; 
              
                
               
               }
               }
                if (i<=17){
                   System.out.println("Enter...You can choose [" + (i+1) + "," + (i+2) +"," +(i+3) + "]");
                   int player1 = scanner.nextInt();
               
               int comp = (ran.nextInt(3)+1) + player1;
               i = comp;
               System.out.println("I choose " + comp);
                 if(comp == 21){
                     System.out.println("I loose");
                     Quit();
                 }
                 else if(player1 == 21){
                     System.out.println("You Loose");
                     Quit();
               
                 }
                  
               }
               }
        
        
        
    }
}

    

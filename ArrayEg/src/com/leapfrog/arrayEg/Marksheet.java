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
public class Marksheet {
int pass = 32;
   boolean fail = false;
   double total = 0;
   Scanner input;
   String [] subjects;
   double [] marks;
   public Marksheet(String[] subjects,Scanner input){
    marks = new double[subjects.length];
    this.subjects = subjects;
    this.input = input;
       
   }
   
public void getMarks() {
   int num = subjects.length;
    for (int i = 0;i<num;i++){
         System.out.println("Enter Marks for "+ subjects[i]);
         marks [i]= input.nextInt();
         total = total + marks[i];
       }
}   

public boolean checkfail(){
     int num = subjects.length;
    for (int i=0;i<num;i++){
           if (marks[i]<pass){
            return true;
            
           }
          
       }
    return false;
}

public void getPercentage(){
    System.out.println("Your Percentage is " + (total/subjects.length));
}

public void getDivision() {
    double perc = (total/subjects.length);
        if (perc >=32 && perc<50) {
            System.out.println("You have scored third division");
        }
        else if(perc>=50 && perc <60)
        {
            System.out.println("You have scored second division");
        }
        else if(perc>=60 && perc <80)
        {
            System.out.println("You have scored first division");
        }
        else
        {
            System.out.println("You have scored distinction");
        }
    }
    
}
    
  
   
   


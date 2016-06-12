/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.interFacePractise1;

/**
 *
 * @author chira
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
   
           public static void main(String[] args) {
        
       FootballPlayer fp=new FootballPlayer();
       
    FootballPlayerDAO fpDao=new RonaldoDAOimplement();
//       FootballPlayerDAO fpDao=new PayetDAOimplement();
       fpDao.insert(fp);
    fpDao.setJerseyNumber(7);
    System.out.println(fpDao.getJerseyNumber());
     

    }
    
}

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
public class PayetDAOimplement implements FootballPlayerDAO{
  int jerseyNumber;
 
    @Override
    public String insert(FootballPlayer fp) {
        System.out.println("Dimitri Payet");
        return "Payet";
    }

    @Override
    public boolean delete(String position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber=jerseyNumber;
    }
    
    
      
}

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
public interface FootballPlayerDAO {
 
    String insert(FootballPlayer fp);
    boolean delete(String position);
    int getJerseyNumber();
    void setJerseyNumber(int jerseyNumber);
}
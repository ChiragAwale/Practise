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
public class FootballPlayer {
       String position,club;
    int jerseyNumber;

    public FootballPlayer() {
    }

    public FootballPlayer(String position, String club, int jerseyNumber) {
        this.position = position;
        this.club = club;
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    
     
}


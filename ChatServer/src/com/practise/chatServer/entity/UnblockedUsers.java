/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.entity;

/**
 *
 * @author chira
 */
public class UnblockedUsers {
    private String userName;

    public UnblockedUsers() {
    }

    public UnblockedUsers(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UnblockedUsers{" + "userName=" + userName + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.entity;

import java.net.Socket;

/**
 *
 * @author chira
 */
public class Client {
    private Socket socket;
    private String userName;
  

    public Client() {
    }

    public Client(Socket socket, String userName) {
        this.socket = socket;
        this.userName = userName;
    }
    
    

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}




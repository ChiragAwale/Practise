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
public class BlockedUsersId {
    int id;
    

    public BlockedUsersId() {
    }

    public BlockedUsersId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BlockedUsersId{" + "id=" + id + '}';
    }
    
    
}

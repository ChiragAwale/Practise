/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.dao;

import com.practise.chatServer.entity.BlockedUsersId;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author chira
 */
public interface BlockDao {
List<BlockedUsersId> getAll(String userName)  throws ClassNotFoundException, SQLException;
int block(String userName,int id);
int unblock(String userName,int id);

}

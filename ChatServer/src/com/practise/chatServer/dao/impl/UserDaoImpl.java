/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.dao.impl;

import com.practise.chatServer.dao.BlockDao;
import com.practise.chatServer.dao.UsersDao;
import com.practise.chatServer.dbutil.DbConnection;
import com.practise.chatServer.entity.BlockedUsersId;
import com.practise.chatServer.entity.Client;
import com.practise.chatServer.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chira
 */
public class UserDaoImpl implements UsersDao {

    DbConnection db = new DbConnection();

    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException {

        List<User> usersList = new ArrayList<>();

        db.open();
        String sql = ("Select * from users");
        db.initStatement(sql);

        ResultSet result = db.query();
        while (result.next()) {

            User u = new User();
            u.setId(result.getInt("Id"));
            u.setUserName(result.getString("User_Name"));
            u.setPassword(result.getString("Password"));
            usersList.add(u);

        }

        return usersList;
    }

    @Override
    public User login(String userName, String password) {
        try {
            for (User u : getAll()) {

                if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                    return u;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return null;
    }

    @Override
    public int getId(String userName) {
        try {
            for (User u : getAll()) {

                if (u.getUserName().equalsIgnoreCase(userName)) {
                    return u.getId();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return 0;
    }

}

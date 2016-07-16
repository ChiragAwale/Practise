/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.dao.impl;

import com.practise.chatServer.dao.BlockDao;
import com.practise.chatServer.dbutil.DbConnection;
import com.practise.chatServer.entity.BlockedUsersId;

import com.practise.chatServer.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chira
 */
public class BlockDaoImpl implements BlockDao {

    DbConnection db = new DbConnection();

    @Override
    public List<BlockedUsersId> getAll(String userName) throws ClassNotFoundException, SQLException {

        List<BlockedUsersId> blockedUserList = new ArrayList<>();

        db.open();
        String sql = ("Select * from tbl_block_" + userName.toLowerCase());
        db.initStatement(sql);

        ResultSet result = db.query();
        while (result.next()) {

            BlockedUsersId blockedUsersId = new BlockedUsersId();
            blockedUsersId.setId(result.getInt("Id"));
            blockedUserList.add(blockedUsersId);

        }

        return blockedUserList;
    }

    @Override
    public int block(String userName, int id) {

        try {
            db.open();
            String sql = ("INSERT INTO tbl_block_" + userName.toLowerCase() + "(Id) VALUES(?)");
            PreparedStatement statement = db.initStatement(sql);
            statement.setInt(1, id);

            int result = db.update();
            db.close();
            return result;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return 0;
    }

    @Override
    public int unblock(String userName, int id) {
        try {
            db.open();
            String sql = ("DELETE from tbl_block_" + userName.toLowerCase() + " where id=?");
            PreparedStatement statement = db.initStatement(sql);
            statement.setInt(1, id);

            int result = db.update();
            db.close();
            return result;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return 55;
    }

}

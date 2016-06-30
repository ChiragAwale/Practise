/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chira
 */
public class DbConnection {

    private Connection con = null;
    private PreparedStatement statement = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/SchoolManageMentSystem", "root", "");
    }

    public PreparedStatement initStatement(String sql) throws SQLException {
        statement = con.prepareStatement(sql);
        return statement;
    }

    public ResultSet query() throws SQLException {
        return statement.executeQuery();
    }

    public int update() throws SQLException {
        return statement.executeUpdate();
    }

    public void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
            con = null;
        }
    }
}

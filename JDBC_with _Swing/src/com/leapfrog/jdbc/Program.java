/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc;

import com.leapfrog.jdbc.UI.Menu;

import java.sql.SQLException;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Menu menu = new Menu();
        menu.setVisible(true);
    }
}

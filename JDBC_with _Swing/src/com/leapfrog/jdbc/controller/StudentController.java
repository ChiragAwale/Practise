/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc.controller;

import com.leapfrog.jdbc.UI.Add;
import com.leapfrog.jdbc.UI.Delete;
import com.leapfrog.jdbc.UI.Search;
import com.leapfrog.jdbc.UI.ShowAll;
import com.leapfrog.jdbc.UI.Update;
import com.leapfrog.jdbc.dao.StudentDao;
import com.leapfrog.jdbc.dao.impl.StudentDaoImpl;
import com.leapfrog.jdbc.entity.Student;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class StudentController {

    Scanner input;
    StudentDao studentDao = new StudentDaoImpl();

    public StudentController(Scanner input) {
        this.input = input;
    }

    public void add() {
        Add add = new Add();
        add.setVisible(true);
    }

    public void delete() throws ClassNotFoundException, SQLException {
       Delete delete = new Delete();
       delete.setVisible(true);

    }

    public void get() throws ClassNotFoundException, SQLException {
        Search search = new Search();
        search.setVisible(true);
    }

    public void menu() {
        System.out.println("Welcome to School Management System");
        System.out.println("1.Add Record");
        System.out.println("2.Delete Record ");
        System.out.println("3.Show All Records");
        System.out.println("4.Search Record");
        System.out.println("5.Update Records");
        System.out.println("6.Exit");
        System.out.println("Enter your choice[1-7]");
    }

    public void getALl() throws ClassNotFoundException, SQLException {
     ShowAll showAll = new ShowAll();
     showAll.setVisible(true);
    }

    public void update() throws ClassNotFoundException, SQLException {
        Update update = new Update();
        update.setVisible(true);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc.controller;

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
        try {
            while (true) {
                Student s = new Student();
                System.out.println("Enter First name");
                s.setFirstName(input.next());
                System.out.println("Enter Last name");
                s.setLastName(input.next());
                System.out.println("Enter Email");
                s.setEmail(input.next());
                System.out.println("Enter Status(true/false)");
                s.setStatus(input.nextBoolean());

                int result = studentDao.insert(s);
                if (result == 1) {
                    System.out.println("Record Added");
                } else {
                    System.out.println("Record not Added");
                }
                System.out.println("Do you want to add more?[y/n]");
                if (input.next().equalsIgnoreCase("n")) {
                    break;
                }
            }

        } catch (SQLException | ClassNotFoundException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void delete() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter Id to Delete");
            int id = input.nextInt();
            int result = studentDao.delete(id);
            if (result == 1) {
                System.out.println("Record Deleted");
            } else {
                System.out.println("Record not Deleted/Found");
            }
            System.out.println("Do you want to Delete more?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }
//Yet to complete

    public void getById() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter Id to Search");
            int id = input.nextInt();
            studentDao.getById(id).forEach(c -> {
                System.out.println(c.toString());
            });
            System.out.println("Do you want to search by id again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void getByName() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter Name or part of Name to Search");
            String name = input.next();
            studentDao.getByName(name).forEach(c -> {
                System.out.println(c.toString());
            });
            System.out.println("Do you want to search by name again?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void menu() {
        System.out.println("Welcome to School Management System");
        System.out.println("1.Add Record");
        System.out.println("2.Delete Record ");
        System.out.println("3.Show All Records");
        System.out.println("4.Search by Id");
        System.out.println("5.Search by Name");
        System.out.println("6.Update Records");
        System.out.println("7.Exit");
        System.out.println("Enter your choice[1-7");
    }

    public void getALl() throws ClassNotFoundException, SQLException {
        studentDao.getAll().forEach(c -> {
            System.out.println(c.toString());
        });
    }

    public void update() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter Id of Record to update: ");
            int id = input.nextInt();
            
            Student s = new Student();
            s.setId(id);
            System.out.println("Enter First name");
            s.setFirstName(input.next());
            System.out.println("Enter Last name");
            s.setLastName(input.next());
            System.out.println("Enter Email");
            s.setEmail(input.next());
            System.out.println("Enter Status(true/false)");
            s.setStatus(input.nextBoolean());
            int result = studentDao.udpate(id, s);
             if (result == 1) {
                System.out.println("Record Updated");
            } else {
                System.out.println("Record not Updated/Found");
            }

            System.out.println("Do you want to Update more?[y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}


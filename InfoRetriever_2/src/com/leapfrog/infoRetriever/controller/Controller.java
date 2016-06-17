/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.infoRetriever.controller;

import com.leapfrog.infoRetriever.entity.Student;

import com.leapfrog.infoRetriever.studentDao.StudentDao;
import com.leapfrog.infoRetriever.studentDao.impl.StudentDaoImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author chira
 */
public class Controller {

    StudentDao stDao = new StudentDaoImpl();

    public void addAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\Practise\\InfoRetriever_2\\data.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
              

                String[] tokens = line.split(",");

                if (tokens.length >= 5) {
                    Student student = new Student();
                    student.setId(Integer.parseInt(tokens[0]));
                    student.setFirstName(tokens[1]);
                    student.setLastName(tokens[2]);
                    student.setEmail(tokens[3]);
                    if (Integer.parseInt(tokens[4]) == 1) {
                        student.setStatus(true);
                    }
                    if (Integer.parseInt(tokens[4]) == 0) {
                        student.setStatus(false);

                    }
                    boolean a = stDao.checkEmail(student);
                    boolean b = stDao.checkId(student);
                    if (a == false && b == false) {
                        stDao.add(student);
                    }

                }

            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
    }

    public void showAll() {
        for (Student stdp : stDao.showAll()) {
            System.out.println("Id: " + stdp.getId());
            System.out.println("First Name: " + stdp.getFirstName());
            System.out.println("Last Name: " + stdp.getLastName());
            System.out.println("Email: " + stdp.getEmail());
            if (stdp.isStatus() == true) {
                System.out.println("Status: Currently Enrolled");
            } else if (stdp.isStatus() == false) {
                System.out.println("Status: N/A");
            }
        }
    }

}

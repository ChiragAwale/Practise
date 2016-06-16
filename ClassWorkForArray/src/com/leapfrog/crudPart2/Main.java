/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2;

import com.leapfrog.crudPart2.dao.StudentDao;
import com.leapfrog.crudPart2.dao.impl.StudentDaoImpl;
import com.leapfrog.crudPart2.entity.Student;
import java.util.Scanner;

import com.leapfrog.crudPart2.raw.Data;
import java.util.ArrayList;

/**
 *
 * @author chirag
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] data = Data.getData();
        boolean temp;
        String[] check = new String[5];
        StudentDao stdao = new StudentDaoImpl();

        for (int i = 0; i < data.length; i++) {
            System.out.println("tokens" + i);

            String[] tokens = data[i].split(",");

            if (tokens.length >= 5) {

                Student s = new Student();
                s.setId(Integer.parseInt(tokens[0]));
                s.setFirstName(tokens[1]);
                s.setLastName(tokens[2]);
                s.setEmail(tokens[3]);
                if (tokens[4] == "1") {
                    temp = true;
                } else {
                    temp = false;
                }
                s.setStatus(temp);
                stdao.insertTenp(s);

                for (Student print : stdao.showAll()) {
                    System.out.println(print.getId());
                    System.out.println(print.getEmail());
                    System.out.println(print.getFirstName());
                    System.out.println(print.getLastName());
                    System.out.println(print.isStatus());

                }

            }

        }

    }
}

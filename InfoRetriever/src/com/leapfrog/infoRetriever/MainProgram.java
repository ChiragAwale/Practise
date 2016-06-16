/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.infoRetriever;

import com.leapfrog.infoRetriever.entity.Student;
import com.leapfrog.infoRetriever.studentDao.StudentDao;
import com.leapfrog.infoRetriever.studentDao.impl.StudentDaoImpl;

/**
 *
 * @author chira
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDao stDao = new StudentDaoImpl();
        String[] rd = new String[10];
        rd[0] = "1,Ram,Shrestha,ram@gmail.com,0";
        rd[1] = "2,Gopal,Shrestha,ra123@gmail.com,1";
        rd[2] = "3,Binit,Sthapit,Binit@gmail.com,1";
        rd[3] = "3,Sanim,Maharjan,Sanim@gmail.com,1";
        rd[4] = "5,Ram,Maharjan,ram@gmail.com,0";
        rd[5] = "8,Nimesh,Karki,sdd@gmail.com,0";
        rd[6] = "7,Karki,Hari@gmail.com,0";
        rd[7] = "8,Shyam,Shrestha,Shyam@gmail.com,1";
        rd[8] = "9,,";
        rd[9] = "10,Rame,ram@gmail.com,0";

        for (int i = 0; i < 10; i++) {
            String[] tokens = rd[i].split(",");

            if (tokens.length >= 5) {
                Student student = new Student();
                student.setId(Integer.parseInt(tokens[0]));
                student.setFirstName(tokens[1]);
                student.setLastName(tokens[2]);
                student.setEmail(tokens[3]);
                if (tokens[4] == "1") {
                    student.setStatus(true);
                }
                if (tokens[4] == "0") {
                    student.setStatus(false);

                }
                stDao.add(student);
              

            }
        }

        for (Student stdp : stDao.showAll()) {
            System.out.println("Id: " + stdp.getId());
            System.out.println("First Name: " + stdp.getFirstName());
            System.out.println("Last Name: " + stdp.getLastName());
            System.out.println("Email: " + stdp.getEmail());
            System.out.println("Status: " + stdp.isStatus());

        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.infoRetriever.controller;

import com.leapfrog.infoRetriever.entity.Student;
import com.leapfrog.infoRetriever.rawData.RawData;
import com.leapfrog.infoRetriever.studentDao.StudentDao;
import com.leapfrog.infoRetriever.studentDao.impl.StudentDaoImpl;

/**
 *
 * @author chira
 */
public class Controller {
    StudentDao stDao = new StudentDaoImpl();
    public void addAll(){
        String[] rd = RawData.data();
    

        for (int i = 0; i < 10; i++) {
            String[] tokens = rd[i].split(",");

            if (tokens.length >= 5) {
                Student student = new Student();
                student.setId(Integer.parseInt(tokens[0]));
                student.setFirstName(tokens[1]);
                student.setLastName(tokens[2]);
                student.setEmail(tokens[3]);
                if (Integer.parseInt(tokens[4])==1) {
                    student.setStatus(true);
                }
                if (Integer.parseInt(tokens[4])==0) {
                    student.setStatus(false);

                }
                boolean a = stDao.checkEmail(student);
                boolean b = stDao.checkId(student);
                if (a==false && b ==false){
                stDao.add(student);
                }

            }
        }
    }
    public void showAll(){
         for (Student stdp : stDao.showAll()) {
            System.out.println("Id: " + stdp.getId());
            System.out.println("First Name: " + stdp.getFirstName());
            System.out.println("Last Name: " + stdp.getLastName());
            System.out.println("Email: " + stdp.getEmail());
            if(stdp.isStatus()==true){
                System.out.println("Status: Currently Enrolled");
            }
            else if(stdp.isStatus()==false){
            System.out.println("Status: N/A");
            }
        }
    }
    
}

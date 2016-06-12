/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud;
import com.leapfrog.crud.entity.Student;
import com.leapfrog.crud.studentDao.StdDao;
import com.leapfrog.crud.studentDao.imp.St;
/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student stud = new Student();
        StdDao sd = new St();
        sd.ins(stud);
        
        
    
    }
    
}

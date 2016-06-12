/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud.studentDao.imp;

import com.leapfrog.crud.entity.Student;
import com.leapfrog.crud.studentDao.StdDao;

/**
 *
 * @author chirag
 */
public class St implements StdDao{

    @Override
    public boolean ins(Student sam) {
        System.out.println("test");
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Student s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
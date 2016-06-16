/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.dao.impl;

import com.leapfrog.crudPart2.dao.StudentDao;
import com.leapfrog.crudPart2.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author chira
 */
public class StudentDaoImpl implements StudentDao {
    private ArrayList<Student> studentList=new ArrayList<>();
    private ArrayList<Student> studentListTemp=new ArrayList<>();
    
    public StudentDaoImpl(ArrayList<Student> studentListTemp){
        this.studentListTemp=studentListTemp;
    }

    public StudentDaoImpl() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    @Override
    public boolean insert(Student s) {
    studentList.add(s);   
    return true;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertTenp(Student s) {
        studentListTemp.add(s);
        return true;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Student> showAll() {
        return studentListTemp;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud.studentDao;

import com.leapfrog.crud.entity.Student;

/**
 *
 * @author chira
 */
public interface StdDao {
    boolean ins(Student sam);
    Student getById(int id);
    boolean delete(Student s);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc.dao;

import com.leapfrog.jdbc.entity.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author chira
 */
public interface StudentDao {

    int insert(Student s) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;
    int udpate(int id,Student s) throws ClassNotFoundException, SQLException;

    List<Student> getAll() throws ClassNotFoundException, SQLException;

    List<Student> getByName(String name) throws ClassNotFoundException, SQLException;

    List<Student> getById(int id) throws ClassNotFoundException, SQLException;

}

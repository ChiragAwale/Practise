/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2.dao;

import com.leapfrog.crudPart2.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author chirag
 */
public interface StudentDao {
 boolean insert(Student s);
 boolean insertTenp(Student s);
 ArrayList<Student>showAll();
}

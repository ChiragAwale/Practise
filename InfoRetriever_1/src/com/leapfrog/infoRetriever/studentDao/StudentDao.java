/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.infoRetriever.studentDao;

import com.leapfrog.infoRetriever.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author chirag
 */
public interface StudentDao {

    boolean add(Student s);

    ArrayList<Student> showAll();

    boolean delete(Student s);

    boolean checkEmail(Student s);

    boolean checkId(Student s);

}

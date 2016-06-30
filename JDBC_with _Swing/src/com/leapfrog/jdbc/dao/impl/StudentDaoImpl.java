/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc.dao.impl;

import com.leapfrog.jdbc.dao.StudentDao;
import com.leapfrog.jdbc.dbutil.DbConnection;
import com.leapfrog.jdbc.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author chira
 */
public class StudentDaoImpl implements StudentDao {

    private DbConnection db = new DbConnection();

    @Override
    public int insert(Student s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = ("INSERT INTO tbl_student(First_Name,Last_Name,Email_id,Status) VALUES(?,?,?,?)");
        PreparedStatement statement = db.initStatement(sql);
        statement.setString(1, s.getFirstName());
        statement.setString(2, s.getLastName());
        statement.setString(3, s.getEmail());
        statement.setBoolean(4, s.isStatus());

        int result = db.update();
        db.close();
        return result;

    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = ("DELETE from tbl_student WHERE id=?");
        PreparedStatement statement = db.initStatement(sql);
        statement.setInt(1, id);

        int result = db.update();
        db.close();
        return result;

    }

    @Override
    public List<Student> getByName(String name) throws ClassNotFoundException, SQLException {
        List<Student> studentList = new ArrayList<>();
        db.open();
        String sql = ("select* from tbl_student where First_Name like '%" + name + "%'");
        PreparedStatement statement = db.initStatement(sql);

        ResultSet result = db.query();
        while (result.next()) {
            Student s = new Student();

            s.setId(result.getInt("id"));
            s.setFirstName(result.getString("First_name"));
            s.setLastName(result.getString("Last_Name"));
            s.setEmail(result.getString("email_id"));
            s.setStatus(result.getBoolean("Status"));
            s.setAdded_date(result.getString("Added_date"));
            s.setModified_date(result.getString("Modified_date"));
            studentList.add(s);
        }

        db.close();
        return studentList;
    }

    @Override
    public List<Student> getAll() throws ClassNotFoundException, SQLException {
        List<Student> studentList = new ArrayList<>();
        db.open();
        String sql = ("select* from tbl_student");
        db.initStatement(sql);
        db.initStatement(sql);
        ResultSet result = db.query();
        while (result.next()) {

            Student s = new Student();
            s.setId(result.getInt("id"));
            s.setFirstName(result.getString("First_Name"));
            s.setLastName(result.getString("Last_Name"));
            s.setEmail(result.getString("email_id"));
            s.setStatus(result.getBoolean("Status"));
            s.setAdded_date(result.getString("Added_date"));
            s.setModified_date(result.getString("Modified_date"));
            studentList.add(s);

        }
        return studentList;
    }

    @Override
    public List<Student> getById(int id) throws ClassNotFoundException, SQLException {
        List<Student> studentList = new ArrayList<>();
        db.open();
        String sql = ("select * from tbl_student where id=?");
        PreparedStatement statement = db.initStatement(sql);
        statement.setInt(1, id);
        ResultSet result = db.query();
        while (result.next()) {
            Student s = new Student();
            s.setId(result.getInt("id"));
            s.setFirstName(result.getString("First_name"));
            s.setLastName(result.getString("Last_Name"));
            s.setEmail(result.getString("email_id"));
            s.setStatus(result.getBoolean("Status"));
            s.setAdded_date(result.getString("Added_date"));
            s.setModified_date(result.getString("Modified_date"));
            studentList.add(s);
        }

        db.close();
        return studentList;
    }

    @Override
    public int udpate(int id, Student s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = ("update tbl_student set First_Name=?,Last_Name=?,Email_id=?,Status=?,modified_date=? where id =?");
        PreparedStatement statement = db.initStatement(sql);

        statement.setString(1, s.getFirstName());
        statement.setString(2, s.getLastName());
        statement.setString(3, s.getEmail());
        statement.setBoolean(4, s.isStatus());
        statement.setInt(6, s.getId());
        statement.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        int result = db.update();
        db.close();
        return result;

    }

}

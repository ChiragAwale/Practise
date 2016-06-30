/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdbc;

import com.leapfrog.jdbc.controller.StudentController;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        StudentController controller = new StudentController(input);
        while (true) {

            controller.menu();

            switch (input.nextInt()) {
                case 1:
                    controller.add();
                    break;
                case 2:
                    controller.delete();
                    break;
                case 3:
                    controller.getALl();
                    break;
                case 4:
                    controller.getById();
                    break;
                case 5:
                    controller.getByName();
                    break;
                case 6:
                    controller.update();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

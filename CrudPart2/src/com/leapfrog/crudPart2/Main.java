/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crudPart2;

import java.util.Scanner;
import com.leapfrog.crudPart2.controller.Controller;

/**
 *
 * @author chirag
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller c = new Controller(input);
        while (true) {
            c.process();

        }
    }
}

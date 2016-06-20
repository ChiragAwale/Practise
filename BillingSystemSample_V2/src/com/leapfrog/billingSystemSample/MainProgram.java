/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.billingSystemSample;

import com.leapfrog.billingSystemSample.controller.Controller;

/**
 *
 * @author chira
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Controller control = new Controller();
       control.add();
       
       control.menu();
       
       }
    
}

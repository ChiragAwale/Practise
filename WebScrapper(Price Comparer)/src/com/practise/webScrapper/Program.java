/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper;

import com.practise.webScrapper.controller.Controller;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            Controller controller = new Controller();
            controller.menu();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter item you want to search");
            String search = input.next();
            System.out.println("Searching in Kaymu.com.np");
            controller.kaymu(search);
            System.out.println("Searching in MeroShopping.com");
            controller.meroShopping(search);
            System.out.println("Searching in GoGazzab.com");
            controller.goGazzab(search);
            controller.showAll();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}

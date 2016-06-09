/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.schoolManagmentSystem;

import java.util.Scanner;

/**
 *
 * @author chirag
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Helper help = new Helper(input);
        while (true) {
            help.menu();

            int choice = input.nextInt();
            if (choice == 1) {
                help.add();
            }
            if (choice == 2) {
                help.delete();
            }
            if (choice == 3) {
                help.search();
            }
            if (choice == 4) {
                help.showAll();
            }
            if (choice == 5) {
                System.exit(0);
            }

        }
    }
}

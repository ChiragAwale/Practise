/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.multiplicationTable;

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
        Scanner input = new Scanner(System.in);
        int e =0, f = 0, g = 0;
        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++){
                int m = (i*j);
                System.out.println(i + "*" + j + "=" + m);
                e = e + m;
                if ((j%2)==0){
                    f = f + m;
                }
                else { g = g + m;
                }
            }
            System.out.println("Sum of all = " + e);
            System.out.println("Sum of even = " + f);
            System.out.println("Sum of odd= " + g);
            System.out.println("======================================");
        e = 0;
        f = 0;
        g = 0;
        }
            }
        }
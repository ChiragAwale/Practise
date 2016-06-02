/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.calculatorver2.util;

/**
 *
 * @author chira
 */
public class Calculation {
    public int add(int x, int y){
        return x+y;
    }
    public int sub(int x, int y){
        return x-y;
    }
    public int mul(int x, int y){
        return x*y;
    }
    public int division(int x, int y){
        return x/y;
    }
    public int pwr(int x, int y){
        int tot = 1;
            for(int l=1; l<=y;l++){
               tot = tot * x;
            
            }
        return tot;
    }
    
}


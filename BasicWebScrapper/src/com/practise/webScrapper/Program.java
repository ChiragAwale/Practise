/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter URL");
            String link = input.next();
            System.out.println("Connecting to: " + link);
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line = "";
            while((line=reader.readLine())!=null){
                content.append(line + "\r\n");
            }
            System.out.println(content.toString());
            
            
            
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

}

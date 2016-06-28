/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.notePad.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author chira
 */
public class Rw {
    StringBuilder content;

    public static String reader(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line + "\t\n");
            }

            reader.close();
            return content.toString();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return null;
    }

    public static void writer(String file, String text) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);

            writer.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static Boolean Check(String file, String text) {
        String contemp = "";
        String contemp1 = "";
        StringBuilder content = new StringBuilder();
        
        
        try {
            FileReader reader1 = new FileReader(file);

           
            StringBuilder content1 = new StringBuilder();
            int i=0;
            content1 = new StringBuilder();
            while ((i = reader1.read()) != -1) {
               content1.append((char)i);
            }
              
            
          
            reader1.close();
            if (content.equals(content1)) {
                System.out.println("true");
                return true;
            } else if (!content.equals(content1)) {
                System.out.println("false");
                return false;
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return null;
    }
    public Boolean chck1 (String text){
        try {
            FileWriter writer = new FileWriter("C:\\Users\\chira\\Desktop\\temp.txt");
            writer.write(text);
            writer.close();

            FileReader reader = new FileReader("C:\\Users\\chira\\Desktop\\temp.txt");
           
            int i=0;
            content = new StringBuilder();
            while ((i = reader.read()) != -1) {
               content.append((char)i);
            }
            

            reader.close();
           
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return false;
    }

}

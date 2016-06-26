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
    
    public static Boolean Check(String file,String text) {
        String contemp = "";
        String contemp1= "";
        try {
            FileWriter writer = new FileWriter("C:\\Users\\chira\\Desktop\\temp.txt");
            writer.write(text);
            writer.close();
            
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\chira\\Desktop\\temp.txt"));
            String line = "";
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line + "\t\n");
                
            }
            contemp = content.toString();
           
            reader.close();
            
            BufferedReader reader1 = new BufferedReader(new FileReader(file));
            System.out.println(file);
            String line1 = "";
            StringBuilder content1 = new StringBuilder();
            while ((line1 = reader1.readLine()) != null) {
                content1.append(line + "\t\n");
            }

            reader.close();
            contemp1 = content1.toString();
            
            if(contemp.equals(contemp1)){
                System.out.println("true");
                return true;
            }
            else{
                System.out.println("false");
                return false;
            }
          
            
            
            
      
    
      } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return null;
    }
    
}

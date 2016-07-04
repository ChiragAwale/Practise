/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper;

import com.practise.webScrapper.util.Grabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("Instagram photo downloader");
        System.out.println("( For Education Purpose Only )");
        String baseUrl = "https://instagram.com/";
        System.out.println("Enter Instagram username");
        String link = input.next();
        try {
            Grabber grabber = new Grabber();
            String regEx = "https://(.*?).jpg";

            Pattern pattern = Pattern.compile(regEx);

            Matcher matcher = pattern.matcher(grabber.getBody(baseUrl+link));
           
            while (matcher.find()) {
                String imgPath = (matcher.group(0));
                
                String path = (imgPath);
                String[] tokens = path.split("/");
               
                
                
                
                System.out.println("Downloading "+ path);
                grabber.downloadImg(path,tokens[tokens.length-1]);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper;

import com.practise.webScrapper.util.Grabber;

import java.io.File;
import java.io.IOException;

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
        System.out.println("Note: You can only download all photos of public profiles of instagram");
        System.out.println("You can download profile pics of private accounts");
        String baseUrl = "https://instagram.com/";
        System.out.println("Enter Instagram username");
        String link = input.next();
        try {
            Grabber grabber = new Grabber();
            String regEx = "https://(.*?).jpg";

            Pattern pattern = Pattern.compile(regEx);

            Matcher matcher = pattern.matcher(grabber.getBody(baseUrl + link));

            while (matcher.find()) {
                String imgPath = (matcher.group(0));

                String path = (imgPath);
                String[] tokens = path.split("/");
                File file = new File("C://instpht");
                if (!file.isDirectory()) {
                    file.mkdir();
                }
                File file1 = new File("C://instpht/" + link);
                if (!file1.isDirectory()) {
                    file1.mkdir();
                }

                System.out.println("Downloading " + path);
                grabber.downloadImg(path, "C://instpht/" + link + "/" + tokens[tokens.length - 1]);
            }
            System.out.println("Your photos are stored in your C drive in a folder named instpht");

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

}

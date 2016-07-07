/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.webScrapper.controller;

import com.practise.webScrapper.dao.ProductDao;
import com.practise.webScrapper.dao.impl.ProductDaoImpl;
import com.practise.webScrapper.entity.Product;
import com.practise.webScrapper.util.Grabber;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chira
 */
public class Controller {

    ProductDao productDao = new ProductDaoImpl();

    public void kaymu(String search) throws IOException {
        String baseUrl = "http://www.kaymu.com.np";
        String link = "http://www.kaymu.com.np/catalog/?q=" + search;
        String regEx = "<a class=\"card-overlay block pr\" href=\"(.*?)\"(.*?)\"Search\" data-track-name=\"(.*?)\"(.*?)local=\"(.*?)\"";
        Pattern pattern = Pattern.compile(regEx);
     
        Matcher matcher = pattern.matcher(Grabber.grab(link));
       
        while (matcher.find()) {
            Product product = new Product();
            product.setProductName(matcher.group(3));
            product.setLink(baseUrl + matcher.group(1));
            product.setPrice("Nrs." + matcher.group(5));
            product.setDealer(baseUrl);
            productDao.add(product);

        }

    }

    public void showAll() {
        System.out.println("Search Results:");
        for (Product p : productDao.getAll()) {
            System.out.print("Product Name: " + p.getProductName() + " | (" + p.getDealer() + ")");
            System.out.print("Product Price: " + p.getPrice() + " | ");
            System.out.println("Prodcut Link: " + p.getLink() + " | ");
        }
    }

    public void meroShopping(String search) throws IOException {
        String baseUrl = "https://www.meroshopping.com/";
        String link = "https://www.meroshopping.com/search/" + search;
        String regEx = "<div class=\"product\" style=\" \">[^>]*<a href=\\\"(.*?)\"(.*?)/>[^>]*>(.*?)</div>[^>]*>(.*?)<";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher1 = pattern.matcher(Grabber.grab(link));

        while (matcher1.find()) {
            Product product = new Product();
            product.setProductName(matcher1.group(3));
            product.setLink(baseUrl + matcher1.group(1));
            product.setPrice(matcher1.group(4));
            product.setDealer(baseUrl);
            productDao.add(product);

        }
    }

    public void goGazzab(String search) throws IOException {
        String baseUrl = "https://www.gogazzab.com/";
        String link = "http://gogazzab.com/catalogsearch/result/?q=" + search;
        String regEx = "<h2 class=\\\"product-name\"><a href=\\\"(.*?)\" title=\\\"(.*?)\"(.*?)h2>[^>]*<(.*?)>[^>]*<(.*?)>[^>]*<(.*?)/span>[^>]*<(.*?)>[^>]*NPR(.*?)<";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(Grabber.grab(link));
   
        while (matcher.find()) {
            Product product = new Product();
            product.setProductName(matcher.group(2));
            product.setLink(matcher.group(1));
            product.setPrice(matcher.group(8).replace(" ", ""));
            product.setDealer(baseUrl);
            productDao.add(product);

        }
    }
    
    public void menu(){
        System.out.println("Welcome to WebScrapper(Commercial sites) price comparer-Chirag Awale.");
        System.out.println("Version 1.0(Testing Phase)");
        System.out.println("Only for Educational Purpose");
    }
}

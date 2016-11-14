/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.salaryHandler.entity;

/**
 *
 * @author chira
 */
public class Salary {

    double amount, tax;
    String name;

    public Salary(double amount, double tax, String name) {

        this.amount = amount;
        this.tax = tax;
        this.name = name;
    }

    public Salary() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salary{" + " amount=" + amount + ", tax=" + tax + ", name=" + name + '}';
    }

}

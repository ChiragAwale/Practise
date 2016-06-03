/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataBase.parts;

/**
 *
 * @author chira
 */
public class It {
    private int noOfWorkers,totalExpensePerMonth,totalBudget;
    private String status;

    public int getNoOfWorkers() {
        return noOfWorkers;
    }

    public void setNoOfWorkers(int noOfWorkers) {
        this.noOfWorkers = noOfWorkers;
    }

    public int getTotalExpensePerMonth() {
        return totalExpensePerMonth;
    }

    public void setTotalExpensePerMonth(int totalExpensePerMonth) {
        this.totalExpensePerMonth = totalExpensePerMonth;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

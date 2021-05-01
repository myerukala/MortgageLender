package com.mortgagelender;

import jdk.jfr.Frequency;

public class Candidate {
    private double requestedAmount;

    private int score;

    private double savings;

    private  int dti;


    public Candidate(double requestedAmount, int score, double savings, int  dti){
        this.requestedAmount = requestedAmount;
        this.score = score;
        this.savings = savings;
        this.dti = dti;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public int getDti() {
        return dti;
    }

    public void setDti(int dti) {
        this.dti = dti;
    }





    public double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

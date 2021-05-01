package com.mortgagelender;

public class MortgageLender {

    private double funds = 75000;
    private double deposit;

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }


    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }


    public double fundsTotal(double deposit) {
        return this.funds += deposit;
    }



}

package com.mortgagelender;

public class MortgageLender {

    private double funds = 75000;
    private double deposit;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    private String qualification;

    private double loanAmount;

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

    public boolean calculateSavingsPercentage(double savings, double requestedAmount){
        double minimumAmount = (requestedAmount * .25);
        if (savings < minimumAmount) {
            return false;
        }else {
            return true;
        }
    }

    public boolean calculateDti(int dti){
        if ( dti > 36){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkCreditScore(int score){
        if ( score > 620 ){
            return true;
        }else {
            return false;
        }
    }

    public String qualifiesCandidate(Candidate candidate){

        if ( checkCreditScore(candidate.getScore()) &&
                calculateDti(candidate.getDti()) &&
                calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount()) ){
            //String.format("qualified");
            loanAmount = candidate.getRequestedAmount();
            status = "qualified";
            qualification = "qualified";
        }else{
            status = "denied";
            qualification = "not qualified";
        }
        return status;
    }

}

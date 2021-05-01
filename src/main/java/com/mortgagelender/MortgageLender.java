package com.mortgagelender;

public class MortgageLender {

    private double funds = 75000;
    private double deposit;
    private String qualification;
    private double loanAmount;
    private String status;
    private double pendingFunds;

    private int dateLoans;

    public int getDateLoans() {
        return dateLoans;
    }

    public void setDateLoans(int dateLoans) {
        this.dateLoans = dateLoans;
    }
    public double getPendingFunds() {
        return pendingFunds;
    }

    public void setPendingFunds(double pendingFunds) {
        this.pendingFunds = pendingFunds;
    }


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
        }else{
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

    public String isPartiallyQualified(Candidate candidate){

        boolean savingsStatus = calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());

        if ( checkCreditScore(candidate.getScore()) &&
                calculateDti(candidate.getDti()) && ! savingsStatus
                ){

            loanAmount = candidate.getSavings() * 4;
            status = "qualified";
            qualification = "partially qualified";
        }else{
            status = "denied";
            qualification = "not qualified";
        }
        return status;
    }

    public String processLoan(Candidate candidate) throws Exception{

        if( ( getFunds() > getLoanAmount() ) && getQualification().equals("qualified")){
            status = "approved";
        }else if(getQualification().equals("not qualified")){
            throw new Exception ("not Proceed");
        }else {
            status = "on hold";
        }
        return status;
    }

    public void moveApprovedFundToPendingFund(Candidate candidate){
        if ( status.equals("approved")){
            pendingFunds = loanAmount;
            funds -= loanAmount;
        }

    }

    public void loanStatus( boolean acceptOfferStatus){
        if ( acceptOfferStatus ){
            status = "accepted";
            pendingFunds -= loanAmount;

        }else {
            status = "rejected";
            funds += loanAmount;
            loanAmount = 0;
        }

    }

    public void checkExpiredLoans(){
        if ( dateLoans >= 3 ){
            funds += loanAmount;
            status = "expired";
        }

    }

}

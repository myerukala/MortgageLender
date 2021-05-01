package com.mortgagelender;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MortgageLenderTestCase {

    @Test
    @DisplayName("As a lender, I want to be able to check my available funds, so that I know how much money I can offer for loans.")

    void checkAvailableFunds(){

        MortgageLender mortgagelender = new MortgageLender();

        assertEquals(75000,mortgagelender.getFunds());

    }

    @Test
    @DisplayName("As a lender, I want to add money to my available funds, so that I can offer loans to potential home buyers.")

    void checkLenderAddDepositAmount(){
        MortgageLender mortgagelender = new MortgageLender();

        mortgagelender.setDeposit(5000);

        double actualValue = mortgagelender.fundsTotal(mortgagelender.getDeposit());

        assertEquals(80000,actualValue);


    }

    @Test
    @DisplayName("Qualify for full amount")
    void validateIfCandidateQualifiesForFullAmount(){
        MortgageLender mortgagelender = new MortgageLender();
        Candidate candidate = new Candidate(5000, 621 , 89999, 36 );
        boolean qualifySavings = mortgagelender.calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());

        assertEquals(true, qualifySavings);

        boolean qualifyDti = mortgagelender.calculateDti(candidate.getDti());
        assertEquals(true, qualifyDti);

        boolean creditScore = mortgagelender.checkCreditScore(candidate.getScore());
        assertEquals(true, creditScore);

        String actualStatusMessage = mortgagelender.qualifiesCandidate(candidate);
        String actualQualified = mortgagelender.getQualification();
        String actualStatus = mortgagelender.getStatus();
        assertAll( () ->  assertEquals ("qualified", actualStatusMessage) ,
                () -> assertEquals( "qualified", actualQualified) ,
                () -> assertEquals( "qualified",actualStatus ));



        //asssertThrows

    }

    @Test
    @DisplayName("Partial qualified amount")
    void testPartialQualifiedAmountForCandidate(){
        MortgageLender mortgagelender = new MortgageLender();
        Candidate candidate = new Candidate(5000, 621 , 100, 36 );
        boolean qualifySavings = mortgagelender.calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());
        assertEquals(false, qualifySavings);

        boolean qualifyDti = mortgagelender.calculateDti(candidate.getDti());
        assertEquals(true, qualifyDti);

        boolean creditScore = mortgagelender.checkCreditScore(candidate.getScore());
        assertEquals(true, creditScore);

        String actualStatusMessage = mortgagelender.isPartiallyQualified(candidate);
        String actualQualified = mortgagelender.getQualification();
        String actualStatus = mortgagelender.getStatus();
        assertAll( () ->  assertEquals ("qualified", actualStatusMessage) ,
                () -> assertEquals( "partially qualified", actualQualified) ,
                () -> assertEquals( "qualified",actualStatus ));


    }

    @Test
    @DisplayName("Displaying not qualified")
    void testCandidateIsNotQualified(){
        MortgageLender mortgagelender = new MortgageLender();
        Candidate candidate = new Candidate(5000, 700 , 1000, 37 );
        boolean qualifySavings = mortgagelender.calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());
        assertEquals(false, qualifySavings);

        boolean qualifyDti = mortgagelender.calculateDti(candidate.getDti());
        assertEquals(false, qualifyDti);

        boolean creditScore = mortgagelender.checkCreditScore(candidate.getScore());
        assertEquals(true, creditScore);

        String actualStatusMessage = mortgagelender.isPartiallyQualified(candidate);
        String actualQualified = mortgagelender.getQualification();
        String actualStatus = mortgagelender.getStatus();
        assertAll( () ->  assertEquals ("denied", actualStatusMessage) ,
                () -> assertEquals( "not qualified", actualQualified) ,
                () -> assertEquals( "denied",actualStatus ));


    }

    @Test
    @DisplayName(" Loan For NOT Proceed")
    void checkNotProceedLoan(){
        MortgageLender mortgagelender = new MortgageLender();
        Candidate candidate = new Candidate(5000, 621 , 89999, 38 );
        boolean qualifySavings = mortgagelender.calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());

        assertEquals(true, qualifySavings);

        boolean qualifyDti = mortgagelender.calculateDti(candidate.getDti());
        assertEquals(false, qualifyDti);

        boolean creditScore = mortgagelender.checkCreditScore(candidate.getScore());
        assertEquals(true, creditScore);

        assertThrows(Exception.class, () -> mortgagelender.processLoan(candidate));
    }

    @Test
    @DisplayName(" Qualified for Approved Loan")
    void checkQualifiedLoanApprovedStatus(){
        MortgageLender mortgagelender = new MortgageLender();
        Candidate candidate = new Candidate(5000, 621 , 89999, 35 );
        boolean qualifySavings = mortgagelender.calculateSavingsPercentage(candidate.getSavings(), candidate.getRequestedAmount());

        assertEquals(true, qualifySavings);

        boolean qualifyDti = mortgagelender.calculateDti(candidate.getDti());
        assertEquals(true, qualifyDti);

        boolean creditScore = mortgagelender.checkCreditScore(candidate.getScore());
        assertEquals(true, creditScore);

        try {
            String processStatus = mortgagelender.processLoan(candidate);

            assertEquals("approved",processStatus);
        }catch(Exception e) {
            e.getMessage();

        }

    }
}

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


}

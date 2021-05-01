package com.mortgagelender;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgageLenderTestCase {

    @Test
    @DisplayName("As a lender, I want to be able to check my available funds, so that I know how much money I can offer for loans.")

    void checkAvailableFunds(){

        MortgageLender mortgagelender = new MortgageLender();

        assertEquals(75000,mortgagelender.getFunds());

    }

}

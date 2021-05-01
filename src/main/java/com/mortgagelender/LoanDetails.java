package com.mortgagelender;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoanDetails {



    private List<MortgageLender> mortgageList;

    public List<MortgageLender> getMortgageList() {
        return mortgageList;
    }

    public void setMortgageList(List<MortgageLender> mortgageList) {
        this.mortgageList = mortgageList;
    }


    public void addMortgage ( MortgageLender ... mortgageList ){
        Arrays.asList(mortgageList)
                .stream()
                .forEach(  loan -> this.mortgageList.add(loan)  );
    }

    public List<MortgageLender> searchBy( String status){
        List<MortgageLender> myListResult = mortgageList
                .stream()
                .filter( element -> element.getStatus().equals(status) )
                .collect(Collectors.toList());
        return myListResult;
    }


}

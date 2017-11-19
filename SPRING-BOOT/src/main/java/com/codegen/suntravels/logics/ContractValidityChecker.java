package com.codegen.suntravels.logics;

import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class ContractValidityChecker {

    Calendar c = Calendar.getInstance();

    public List<ContractDetails> getValidContractDetailsList(List<ContractDetails> contractDetailsList, SearchReservationRequest request){

        List<ContractDetails> validContractDetailsList = null;

        /**
         * If the first element of the contract details list is valid, the rest of the elements of the same list
         * are also valid, because the given contract details list belong to the same contract.
         * So, no need to iterate through the entire contract details list to confirm the validity.
         */
        ContractDetails firstElement = contractDetailsList.get(0);

        Date from = firstElement.getValidFrom();
        Date to = firstElement.getValidTo();
        Date checkIn = request.getCheckInDate();
        Integer numberOfNights = request.getNumberOfNights();

        /**
         * Calculating the checkOut date using number of nights and the checkIn date
         * */
        c.setTime(checkIn);
        c.add(Calendar.DATE, numberOfNights);
        Date checkOut = new Date(c.getTimeInMillis());

        boolean isValidContract = isValid(from, to, checkIn, checkOut);

        if(isValidContract){
            validContractDetailsList = contractDetailsList;
        }
        return validContractDetailsList;
    }

    boolean isValid(Date from, Date to, Date checkIn, Date checkOut){

        boolean validity = (checkIn.after(from) && checkIn.before(to)) && (checkOut.after(from) && checkOut.before(to));
        return validity;
    }
}

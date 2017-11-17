package com.codegen.suntravels.logics;

import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class SearchReservationLogic {

    Calendar c = Calendar.getInstance();

    public List<ContractDetails> getValidContractDetailsList(List<ContractDetails> allContractDetailsList, SearchReservationRequest request){

        List<ContractDetails> validContractDetailsList = new ArrayList<>();

        for(ContractDetails ctrDetails : allContractDetailsList){

            Date from = ctrDetails.getValidFrom();
            Date to = ctrDetails.getValidTo();
            Date checkIn = request.getCheckInDate();
            Integer numberOfNights = request.getNumberOfNights();

            // Calculating the checkOut date using number of nights and the checkIn date
            c.setTime(checkIn);
            c.add(Calendar.DATE, numberOfNights);
            Date checkOut = new Date(c.getTimeInMillis());

            boolean isValidContract = isValid(from, to, checkIn, checkOut);

            if(isValidContract){
                validContractDetailsList.add(ctrDetails);
            }
        }
        return validContractDetailsList;
    }

    boolean isValid(Date from, Date to, Date checkIn, Date checkOut){

        // TODO : implement the logic here
        return false;
    }
}

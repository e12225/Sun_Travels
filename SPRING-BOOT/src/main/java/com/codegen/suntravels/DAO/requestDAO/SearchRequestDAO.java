package com.codegen.suntravels.DAO.requestDAO;

import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.logics.AvailableReservationComposer;
import com.codegen.suntravels.logics.ContractValidityChecker;
import com.codegen.suntravels.logics.RoomsAvailabilityChecker;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchRequestDAO {

    @Autowired
    private ContractValidityChecker contractValidityChecker;

    @Autowired
    private RoomsAvailabilityChecker roomsAvailabilityChecker;

    /**
     * filtering the list of valid contract details from the given list
     */
    public List<ContractDetails> getValidContractDetailsList(List<ContractDetails> contractDetailsList, SearchReservationRequest request){
        return contractValidityChecker.getValidContractDetailsList(contractDetailsList, request);
    }

    /**
     * filtering the list of available room type list from the valid contract list
     */
    public List<AvailableReservationComposer> getRoomTypesWithEnoughRooms(List<ContractDetails> validContracts, SearchReservationRequest request, Contract contract){
        return roomsAvailabilityChecker.getRoomsAvailability(validContracts, request, contract);
    }
}

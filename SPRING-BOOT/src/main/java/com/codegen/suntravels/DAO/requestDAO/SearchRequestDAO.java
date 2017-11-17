package com.codegen.suntravels.DAO.requestDAO;

import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.logics.SearchReservationLogic;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import com.codegen.suntravels.services.entityServices.ContractDetailsService;
import com.codegen.suntravels.services.entityServices.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchRequestDAO {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailsService contractDetailsService;

    @Autowired
    private SearchReservationLogic searchReservationLogic;

    // retrieving the list of contract details
    public List<ContractDetails> getAllContractDetailsList(){
        //TODO : load this list to a Cache object at the beginning
        return contractDetailsService.getContractDetailsList();
    }

    // filtering the list of valid contract details list from the entire list
    public List<ContractDetails> getValidContractDetailsList(List<ContractDetails> allContractDetailsList, SearchReservationRequest request){
        return searchReservationLogic.getValidContractDetailsList(allContractDetailsList, request);
    }
}

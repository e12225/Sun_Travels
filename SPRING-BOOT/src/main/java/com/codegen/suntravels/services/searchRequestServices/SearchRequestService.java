package com.codegen.suntravels.services.searchRequestServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.requestDAO.SearchRequestDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.logics.AvailableReservationComposer;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import com.codegen.suntravels.searchResponses.SearchReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/16/2017.
 */
@Service
public class SearchRequestService {

    @Autowired
    private SearchRequestDAO searchRequestDAO;

    @Autowired
    private ContractDAO contractsDAO;

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    SearchReservationResponse response = new SearchReservationResponse();

    public SearchReservationResponse processSearchRequest(SearchReservationRequest request) {

        //TODO : load the ctrDetails list, contracts list, room types list, hotels list for a cache at the beginning
        List<Contract> contracts = contractsDAO.getContractList();

        List<AvailableReservationComposer> availableReservations = null;

        for(Contract contract : contracts){

            List<ContractDetails> contractDetailsList = contractDetailsDAO.getCtrDetailsByCtrID(contract.getContractID());
            List<ContractDetails> validContractDetailsList = searchRequestDAO.getValidContractDetailsList(contractDetailsList, request);

            if (validContractDetailsList != null){
                /**
                 * i.e the contract and its contract details list(by default) are valid
                 */
                availableReservations = searchRequestDAO.getRoomTypesWithEnoughRooms(validContractDetailsList, request, contract);
            }
        }

        if(availableReservations.size() == 0){
            response.setNumberOfAvailableReservations(0);
            response.setAvailableReservations(availableReservations); // this is set to null
            response.setReservationsAvailability("Not Available");
        }else {
            response.setNumberOfAvailableReservations(availableReservations.size());
            response.setReservationsAvailability("Available");
            response.setAvailableReservations(availableReservations);
        }

        return response;
    }
}

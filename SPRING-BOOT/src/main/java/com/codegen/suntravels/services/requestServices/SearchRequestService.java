package com.codegen.suntravels.services.requestServices;

import com.codegen.suntravels.DAO.requestDAO.SearchRequestDAO;
import com.codegen.suntravels.entities.ContractDetails;
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

    SearchReservationResponse response = new SearchReservationResponse();

    public SearchReservationResponse processSearchRequest(SearchReservationRequest request) {

        List<ContractDetails> validContractDetailsList = searchRequestDAO.getValidContractDetailsList(searchRequestDAO.getAllContractDetailsList(), request);
        //TODO : now use this list and filter further more
        //TODO : implement this further

        response.setHotelName("testing");
        response.setRoomType("test type");
        response.setPrice(25.38);
        response.setRoomAvailability(true);
        return response;
    }
}

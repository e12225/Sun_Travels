package com.codegen.suntravels.controllers.requestControllers;

import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import com.codegen.suntravels.searchResponses.SearchReservationResponse;
import com.codegen.suntravels.services.requestServices.SearchRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 11/16/2017.
 */
@RestController
public class SearchRequestController {

    @Autowired
    private SearchRequestService searchRequestService;

    @RequestMapping(method = RequestMethod.POST, path = "/reservationSearch")
    public SearchReservationResponse getReservationAvailability(@RequestBody SearchReservationRequest request) {

        SearchReservationResponse response = searchRequestService.processSearchRequest(request);
        return response;
    }

}

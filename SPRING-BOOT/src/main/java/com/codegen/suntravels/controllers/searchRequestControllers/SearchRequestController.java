package com.codegen.suntravels.controllers.searchRequestControllers;

import com.codegen.suntravels.searchResponses.AvailableReservationComposer;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import com.codegen.suntravels.services.searchRequestServices.SearchRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 11/16/2017.
 */
@RestController
@RequestMapping(value = "reservations")
public class SearchRequestController {

    @Autowired
    private SearchRequestService searchRequestService;

    @RequestMapping(method = RequestMethod.POST, path = "/search")
    public List<AvailableReservationComposer> getAvailableReservations(@RequestBody SearchReservationRequest request){

        List<AvailableReservationComposer> reservationsList = searchRequestService.processSearchRequest(request);
        return reservationsList;
    }
}

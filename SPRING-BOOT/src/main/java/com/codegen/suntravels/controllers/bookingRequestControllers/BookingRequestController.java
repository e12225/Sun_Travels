package com.codegen.suntravels.controllers.bookingRequestControllers;

import com.codegen.suntravels.bookingRequest.BookingRequest;
import com.codegen.suntravels.bookingResponse.BookingResponse;
import com.codegen.suntravels.services.bookingRequestServices.BookingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bookings")
public class BookingRequestController {

    @Autowired
    private BookingRequestService bookingRequestService;

    @RequestMapping(method = RequestMethod.POST, path = "/confirm")
    public BookingResponse confirmBooking(@RequestBody BookingRequest request){

        BookingResponse response = bookingRequestService.processBookingRequest(request);
        return response;
    }
}

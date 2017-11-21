package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entities.RoomReservation;
import com.codegen.suntravels.reservationResponses.HotelRoomReservationResponse;
import com.codegen.suntravels.services.entityServices.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roomReservations")
public class RoomReservationController {

    @Autowired
    private RoomReservationService roomReservationService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<RoomReservation> getRoomReservationList(){
        return roomReservationService.getRoomReservationList();
    }
}

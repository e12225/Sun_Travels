package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.Reservation;
import com.codegen.suntravels.services.entityServices.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Reservation> getReservationList() {
        return reservationService.getReservationList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }
}

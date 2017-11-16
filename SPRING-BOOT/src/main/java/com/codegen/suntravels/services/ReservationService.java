package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.ReservationDAO;
import com.codegen.suntravels.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    public List<Reservation> getReservationList(){
        return this.reservationDAO.getReservationList();
    }

    public void addReservation(Reservation reservation){
        this.reservationDAO.addReservation(reservation);
    }
}

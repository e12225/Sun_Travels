package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ReservationDAO;
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

    public Reservation getReservationByID(Integer reservationID){
        return this.reservationDAO.getReservationByID(reservationID);
    }
}

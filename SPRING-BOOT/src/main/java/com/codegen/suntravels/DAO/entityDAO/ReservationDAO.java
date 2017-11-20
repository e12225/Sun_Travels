package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.Reservation;
import com.codegen.suntravels.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationDAO {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationList(){
        return reservationRepository.findAll();
    }

    public Integer addReservation(Reservation reservation){
        return reservationRepository.save(reservation).getReservationID();
    }

    public Reservation getReservationByID(Integer reservationID){
        return reservationRepository.getReservationByID(reservationID);
    }
}

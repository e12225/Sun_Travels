package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.RoomReservation;
import com.codegen.suntravels.repositories.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomReservationDAO {

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    public List<RoomReservation> getRoomReservationList(){
        return roomReservationRepository.findAll();
    }

    public Integer addRoomReservation(RoomReservation roomReservation){
        return roomReservationRepository.save(roomReservation).getRoomReservationID();
    }
}

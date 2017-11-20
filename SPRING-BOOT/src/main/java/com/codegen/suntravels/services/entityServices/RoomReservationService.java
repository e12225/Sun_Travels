package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.entityDAO.RoomReservationDAO;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomReservationService {

    @Autowired
    private RoomReservationDAO roomReservationDAO;

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    public List<RoomReservation> getRoomReservationList(){
        return this.roomReservationDAO.getRoomReservationList();
    }

    public Integer addRoomReservation(RoomReservation roomReservation){

        // TODO : update the number of rooms
        return this.roomReservationDAO.addRoomReservation(roomReservation);
    }
}

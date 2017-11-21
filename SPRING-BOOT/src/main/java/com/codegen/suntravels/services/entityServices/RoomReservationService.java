package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.RoomReservationDAO;
import com.codegen.suntravels.entities.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomReservationService {

    @Autowired
    private RoomReservationDAO roomReservationDAO;

    public List<RoomReservation> getRoomReservationList(){
        return this.roomReservationDAO.getRoomReservationList();
    }


}

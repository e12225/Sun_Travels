package com.codegen.suntravels.logics;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.entityDAO.ReservationDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.Reservation;
import com.codegen.suntravels.entities.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractDetailsUpdater {

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    public ContractDetails findContractDetailsToUpdate(RoomReservation roomReservation){

        Reservation reservation = reservationDAO.getReservationByID(roomReservation.getReservationID());

        Integer hotelID = reservation.getHotelID();

        Contract contract = contractDAO.getContractByHotelID(hotelID);

        ContractDetails contractDetails = contractDetailsDAO.getCtrDetailsByCtrIDnRmTypeID(contract.getContractID(), roomReservation.getRoomTypeID());

        return contractDetails;
    }

    public ContractDetails setLatestNumberOfRooms(ContractDetails contractDetails){

        Integer oldNumberOfRooms = contractDetails.getNumberOfRooms();
        return null;

    }
}

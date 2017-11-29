package com.codegen.suntravels.logics;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.DAO.entityDAO.RoomTypeDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by DELL on 11/19/2017.
 */
@Component
public class RoomsAvailabilityChecker {

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private MarkupCalculator markupCalculator;

    public List<AvailableReservationComposer> getRoomsAvailability(List<ContractDetails> validCtrDetailsList, SearchReservationRequest request, Contract contract) {

        List<AvailableReservationComposer> availableReservations = new ArrayList<>();

        Integer numberOfRooms;
        Integer maxAdultsPerRoom;

        Integer testnumberOfAdultsPerRoom = request.getTestnumberOfAdultsPerRoom();
//        ArrayList<Integer> numberOfAdultsPerRoom = request.getNoOfAdultsPerRoom();

        /**
         * Calculating the total number of adults
         */
//        Integer totalAdults = 0;
//        int i;
//        for (i = 0; i < numberOfAdultsPerRoom.size(); i++) {
//            totalAdults += numberOfAdultsPerRoom.get(i);
//        }

        /**
         * getting the maximum number of adults per room in the request
         */
//        Integer requestedMaxAdultsPerRoom = Collections.max(numberOfAdultsPerRoom);

        Integer requiredRoomCount = request.getNumberOfRooms();

        /**
         * traversing through each set contract details related to each room type belong to one contract
         * (i.e one hotel)
         * */
        for (ContractDetails ctrDetails : validCtrDetailsList) {

            numberOfRooms = ctrDetails.getNumberOfRooms();
            maxAdultsPerRoom = ctrDetails.getMaxAdults();

            if (requiredRoomCount <= numberOfRooms && testnumberOfAdultsPerRoom <= maxAdultsPerRoom) {

                /**
                 * The room type is available
                 */
                AvailableReservationComposer reservation = new AvailableReservationComposer();

                RoomType availableRoomType = roomTypeDAO.getRoomTypeByID(ctrDetails.getRoomTypeID());
                Hotel relevantHotel = hotelDAO.getHotelByID(contract.getHotelID());

                Double markedUpPrice = markupCalculator.calculateMarkUpPrice(ctrDetails.getPrice(), testnumberOfAdultsPerRoom, request.getNumberOfNights());

                reservation.setRoomType(availableRoomType.getRoomTypeName());
                reservation.setMarkedUpPrice(markedUpPrice);
                reservation.setHotelName(relevantHotel.getHotelName());
                reservation.setRoomsAvailability("Available");

                availableReservations.add(reservation);
            }
        }
        return availableReservations;
    }
}

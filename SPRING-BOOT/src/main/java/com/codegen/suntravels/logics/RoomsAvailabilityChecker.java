package com.codegen.suntravels.logics;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.DAO.entityDAO.RoomTypeDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import com.codegen.suntravels.searchResponses.AvailableReservationComposer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/19/2017.
 */
@Component
public class RoomsAvailabilityChecker
{

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private MarkupCalculator markupCalculator;

    public List<AvailableReservationComposer> getRoomsAvailability( List<ContractDetails> validCtrDetailsList, SearchReservationRequest request, Contract contract )
    {

        List<AvailableReservationComposer> availableReservations = new ArrayList<>();

        /**
         * getting the maximum number of adults per room, number of rooms and total number of adults from the request
         */
        Integer requestedMaxAdultsPerRoom = request.getRequestedMaxAdultsPerRoom();
        Integer requiredRoomCount = request.getNumberOfRooms();
        Integer totalAdults = request.getTotalAdults();

        /**
         * traversing through the set of valid contract details list belong to one contract
         * (i.e one hotel) which may have different room types
         * */
        Integer numberOfRooms;
        Integer maxAdultsPerRoom;

        for( ContractDetails ctrDetails : validCtrDetailsList )
        {

            numberOfRooms = ctrDetails.getNumberOfRooms();
            maxAdultsPerRoom = ctrDetails.getMaxAdults();

            if( requiredRoomCount <= numberOfRooms && requestedMaxAdultsPerRoom <= maxAdultsPerRoom &&
                    ( numberOfRooms * maxAdultsPerRoom ) >= totalAdults && // checking availability of rooms for the total no of adults
                    ( requiredRoomCount * requestedMaxAdultsPerRoom ) >= totalAdults ) // checking the validity of request
            {
                /**
                 * The room type is available
                 */
                AvailableReservationComposer reservation = new AvailableReservationComposer();

                RoomType availableRoomType = roomTypeDAO.getRoomTypeByID( ctrDetails.getRoomTypeID() );
                Hotel relevantHotel = hotelDAO.getHotelByID( contract.getHotelID() );

                Double markedUpPrice = markupCalculator.calculateMarkUpPrice( ctrDetails.getPrice(), totalAdults, request.getNumberOfNights() );

                reservation.setRoomType( availableRoomType.getRoomTypeName() );
                reservation.setMarkedUpPrice( markedUpPrice );
                reservation.setHotelName( relevantHotel.getHotelName() );
                reservation.setRoomsAvailability( "Available" );

                availableReservations.add( reservation );
            }
        }
        return availableReservations;
    }
}

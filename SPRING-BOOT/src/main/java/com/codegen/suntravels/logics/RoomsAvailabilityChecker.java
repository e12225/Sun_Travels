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
import java.util.Arrays;
import java.util.Collections;
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

        Integer numberOfRooms;
        Integer maxAdultsPerRoom;

        //        Integer noOfAdultsPerRoom = request.getNoOfAdultsPerRoom();
        //        ArrayList<Integer> numberOfAdultsPerRoom = request.getNoOfAdultsPerRoom();
        String noOfAdultsPerRoom = request.getNoOfAdultsPerRoom();

        /**
         * extracting the integer values from th comma separated string
         */
        List<String> noOfAdultsPerRoom_processed = Arrays.asList( noOfAdultsPerRoom.split( "," ) );
        List<Integer> noOfAdultsPerRoom_converted = new ArrayList<>();

        /**
         * String array is converted to an Integer array here
         */
        int i;
        for( i = 0; i < noOfAdultsPerRoom_processed.size(); i++ )
        {
            String x = noOfAdultsPerRoom_processed.get( i );
            Integer y = Integer.parseInt( x );
            noOfAdultsPerRoom_converted.add( y );
        }

        System.out.println( noOfAdultsPerRoom_converted ); // TODO: remove this later

        /**
         * Calculating the total number of adults
         */
        Integer totalAdults = 0;
        int j;
        for( j = 0; j < noOfAdultsPerRoom_processed.size(); j++ )
        {
            totalAdults += Integer.parseInt( noOfAdultsPerRoom_processed.get( j ) );
        }

        /**
         * getting the maximum number of adults per room in the request
         */
        Integer requestedMaxAdultsPerRoom = Collections.max( noOfAdultsPerRoom_converted );

        Integer requiredRoomCount = request.getNumberOfRooms();

        /**
         * traversing through each set of contract details related to each room type belong to one contract
         * (i.e one hotel)
         * */
        for( ContractDetails ctrDetails : validCtrDetailsList )
        {

            numberOfRooms = ctrDetails.getNumberOfRooms();
            maxAdultsPerRoom = ctrDetails.getMaxAdults();

            if( requiredRoomCount <= numberOfRooms && requestedMaxAdultsPerRoom <= maxAdultsPerRoom )
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

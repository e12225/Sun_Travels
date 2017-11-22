package com.codegen.suntravels.services.bookingRequestServices;

import com.codegen.suntravels.DAO.entityDAO.*;
import com.codegen.suntravels.bookingRequest.BookingRequest;
import com.codegen.suntravels.bookingResponse.BookingResponse;
import com.codegen.suntravels.entities.Reservation;
import com.codegen.suntravels.entities.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

@Service
public class BookingRequestService {

    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private RoomReservationDAO roomReservationDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    BookingResponse response = new BookingResponse();

    Reservation reservation = new Reservation();
    RoomReservation roomReservation = new RoomReservation();

    public BookingResponse processBookingRequest(BookingRequest request) {

        reservation.setCustomerID(customerDAO.getCustomerByName(request.getCustomerName()).getCustomerID());
        reservation.setHotelID(hotelDAO.getHotelByName(request.getHotelName()).getHotelID());
        reservation.setCheckInDate(request.getCheckInDate());

        /**
         * Calculating the checkOut date using number of nights and the checkIn date
         * */
        c1.setTime(request.getCheckInDate());
        c1.add(Calendar.DATE, request.getNumberOfNights());
        Date checkOutDate = new Date(c1.getTimeInMillis());

        reservation.setCheckOutDate(checkOutDate);
        reservation.setNumberOfNights(request.getNumberOfNights());
        reservation.setReservedDate(new Date(c2.getTimeInMillis()));

        return response;
    }
}

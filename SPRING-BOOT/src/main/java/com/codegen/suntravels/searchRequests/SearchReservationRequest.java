package com.codegen.suntravels.searchRequests;

import java.sql.Date;

/**
 * Created by DELL on 11/16/2017.
 */
public class SearchReservationRequest {

    private Date checkInDate;

    private Integer numberOfNights;

    private Integer numberOfRooms;

    private Integer numberOfAdults;

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "checkInDate=" + checkInDate +
                ", numberOfNights=" + numberOfNights +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}

package com.codegen.suntravels.searchRequests;

import java.sql.Date;

/**
 * Created by DELL on 11/16/2017.
 */
public class SearchReservationRequest {

    private Date checkInDate;

    private Integer numberOfNights;

    private Integer numberOfRooms;

    private Integer totalAdults;

    private Integer requestedMaxAdultsPerRoom;

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

    public Integer getTotalAdults() {
        return totalAdults;
    }

    public void setTotalAdults(Integer totalAdults) {
        this.totalAdults = totalAdults;
    }

    public Integer getRequestedMaxAdultsPerRoom() {
        return requestedMaxAdultsPerRoom;
    }

    public void setRequestedMaxAdultsPerRoom(Integer requestedMaxAdultsPerRoom) {
        this.requestedMaxAdultsPerRoom = requestedMaxAdultsPerRoom;
    }

    @Override
    public String toString() {
        return "SearchReservationRequest{" +
                "checkInDate=" + checkInDate +
                ", numberOfNights=" + numberOfNights +
                ", numberOfRooms=" + numberOfRooms +
                ", totalAdults=" + totalAdults +
                ", requestedMaxAdultsPerRoom=" + requestedMaxAdultsPerRoom +
                '}';
    }
}

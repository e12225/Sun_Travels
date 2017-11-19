package com.codegen.suntravels.searchRequests;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by DELL on 11/16/2017.
 */
public class SearchReservationRequest {

    private Date checkInDate;

    private Integer numberOfNights;

    private Integer numberOfRooms;

    private ArrayList<Integer> noOfAdultsPerRoom;

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

    public ArrayList<Integer> getNoOfAdultsPerRoom() {
        return noOfAdultsPerRoom;
    }

    public void setNoOfAdultsPerRoom(ArrayList<Integer> noOfAdultsPerRoom) {
        this.noOfAdultsPerRoom = noOfAdultsPerRoom;
    }

    @Override
    public String toString() {
        return "SearchReservationRequest{" +
                "checkInDate=" + checkInDate +
                ", numberOfNights=" + numberOfNights +
                ", numberOfRooms=" + numberOfRooms +
                ", noOfAdultsPerRoom=" + noOfAdultsPerRoom +
                '}';
    }
}

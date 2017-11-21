package com.codegen.suntravels.bookingRequest;

import java.sql.Date;
import java.util.ArrayList;

public class BookingRequest {

    private String customerName;

    private String hotelName;

    private Date checkInDate;

    private Integer numberOfNights;

    private ArrayList<String> roomTypeNames;

    private ArrayList<Integer> numberOfAdults;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

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

    public ArrayList<String> getRoomTypeNames() {
        return roomTypeNames;
    }

    public void setRoomTypeNames(ArrayList<String> roomTypeNames) {
        this.roomTypeNames = roomTypeNames;
    }

    public ArrayList<Integer> getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(ArrayList<Integer> numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "customerName='" + customerName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", checkInDate=" + checkInDate +
                ", numberOfNights=" + numberOfNights +
                ", roomTypeNames=" + roomTypeNames +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}

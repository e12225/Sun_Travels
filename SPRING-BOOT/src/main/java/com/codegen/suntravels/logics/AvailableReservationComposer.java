package com.codegen.suntravels.logics;

/**
 * Created by DELL on 11/19/2017.
 */
public class AvailableReservationComposer {

    private String hotelName;
    private String roomType;
    private Double markedUpPrice;
    private String roomsAvailability;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getMarkedUpPrice() {
        return markedUpPrice;
    }

    public void setMarkedUpPrice(Double markedUpPrice) {
        this.markedUpPrice = markedUpPrice;
    }

    public String getRoomsAvailability() {
        return roomsAvailability;
    }

    public void setRoomsAvailability(String roomsAvailability) {
        this.roomsAvailability = roomsAvailability;
    }

    @Override
    public String toString() {
        return "AvailableReservationComposer{" +
                "hotelName='" + hotelName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", markedUpPrice=" + markedUpPrice +
                ", roomsAvailability='" + roomsAvailability + '\'' +
                '}';
    }
}

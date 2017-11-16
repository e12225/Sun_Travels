package com.codegen.suntravels.searchResponses;

/**
 * Created by DELL on 11/16/2017.
 */
public class SearchReservationResponse {

    private String hotelName;
    private String roomType;
    private Double price; // The marked up price
    private boolean roomAvailability; // true or false

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(boolean roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    @Override
    public String toString() {
        return "SearchReservationResponse{" +
                "hotelName='" + hotelName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", roomAvailability=" + roomAvailability +
                '}';
    }

    //TODO : write test case for this if needed

}

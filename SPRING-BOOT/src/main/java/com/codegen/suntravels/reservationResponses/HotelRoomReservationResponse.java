package com.codegen.suntravels.reservationResponses;

public class HotelRoomReservationResponse {

    private Integer hotelRoomReservationID;

    public Integer getHotelRoomReservationID() {
        return hotelRoomReservationID;
    }

    public void setHotelRoomReservationID(Integer hotelRoomReservationID) {
        this.hotelRoomReservationID = hotelRoomReservationID;
    }

    @Override
    public String toString() {
        return "HotelRoomReservationResponse{" +
                "hotelRoomReservationID=" + hotelRoomReservationID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelRoomReservationResponse that = (HotelRoomReservationResponse) o;

        return hotelRoomReservationID.equals(that.hotelRoomReservationID);
    }

    @Override
    public int hashCode() {
        return hotelRoomReservationID.hashCode();
    }
}

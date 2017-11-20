package com.codegen.suntravels.reservationResponses;

public class HotelReservationResponse {

    private Integer reservationID;

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    @Override
    public String toString() {
        return "HotelReservationResponse{" +
                "reservationID=" + reservationID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelReservationResponse that = (HotelReservationResponse) o;

        return reservationID.equals(that.reservationID);
    }

    @Override
    public int hashCode() {
        return reservationID.hashCode();
    }
}

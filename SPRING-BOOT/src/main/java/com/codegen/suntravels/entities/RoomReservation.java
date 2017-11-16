package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_ROOM_RESERVATION", schema = "SYS", catalog = "")
public class RoomReservation {

    @Id
    @GeneratedValue
    @Column(name = "RR_RM_RESERVATION_ID")
    private Integer roomReservationID;

    @Column(name = "RR_RES_ID")
    private Integer reservationID;

    @Column(name = "RR_RM_TYPE_ID")
    private Integer roomTypeID;

    @Column(name = "RR_NO_OF_ROOMS")
    private Integer numberOfRooms;

    @Column(name = "RR_NO_OF_ADULTS")
    private Integer numberOfAdults;

    public Integer getRoomReservationID() {
        return roomReservationID;
    }

    public void setRoomReservationID(Integer roomReservationID) {
        this.roomReservationID = roomReservationID;
    }

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(Integer roomTypeID) {
        this.roomTypeID = roomTypeID;
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
        return "RoomReservation{" +
                "roomReservationID=" + roomReservationID +
                ", reservationID=" + reservationID +
                ", roomTypeID=" + roomTypeID +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomReservation that = (RoomReservation) o;

        if (!roomReservationID.equals(that.roomReservationID)) return false;
        if (!reservationID.equals(that.reservationID)) return false;
        if (!roomTypeID.equals(that.roomTypeID)) return false;
        if (!numberOfRooms.equals(that.numberOfRooms)) return false;
        return numberOfAdults.equals(that.numberOfAdults);
    }

    @Override
    public int hashCode() {
        int result = roomReservationID.hashCode();
        result = 31 * result + reservationID.hashCode();
        result = 31 * result + roomTypeID.hashCode();
        result = 31 * result + numberOfRooms.hashCode();
        result = 31 * result + numberOfAdults.hashCode();
        return result;
    }
}

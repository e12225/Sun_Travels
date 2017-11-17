package com.codegen.suntravels.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SM_RESERVATION", schema = "SYS", catalog = "")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "RES_ID")
    private Integer reservationID;

    @Column(name = "RES_CUST_ID")
    private Integer customerID;

    @Column(name = "RES_CC_AGENT_ID")
    private Integer callCenterAgentID;

    @Column(name = "SM_HOTEL_ID")
    private Integer hotelID;

    @Column(name = "RES_CHECKIN_DATE")
    private Date checkInDate;

    @Column(name = "RES_CHECKOUT_DATE")
    private Date checkOutDate;

    @Column(name = "RES_NO_OF_NIGHTS")
    private Integer numberOfNights;

    @Column(name = "RES_RESERVED_DATE")
    private Date reservedDate;

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getCallCenterAgentID() {
        return callCenterAgentID;
    }

    public void setCallCenterAgentID(Integer callCenterAgentID) {
        this.callCenterAgentID = callCenterAgentID;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", customerID=" + customerID +
                ", callCenterAgentID=" + callCenterAgentID +
                ", hotelID=" + hotelID +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfNights=" + numberOfNights +
                ", reservedDate=" + reservedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (!reservationID.equals(that.reservationID)) return false;
        if (!customerID.equals(that.customerID)) return false;
        if (!callCenterAgentID.equals(that.callCenterAgentID)) return false;
        if (!hotelID.equals(that.hotelID)) return false;
        return numberOfNights.equals(that.numberOfNights);
    }

    @Override
    public int hashCode() {
        int result = reservationID.hashCode();
        result = 31 * result + customerID.hashCode();
        result = 31 * result + callCenterAgentID.hashCode();
        result = 31 * result + hotelID.hashCode();
        result = 31 * result + numberOfNights.hashCode();
        return result;
    }
}

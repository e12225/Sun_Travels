package com.codegen.suntravels.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 11/15/2017.
 */
@Entity
@Table(name = "SM_CONTRACT_DETAILS", schema = "SYS", catalog = "")
public class ContractDetails {

    @Id
    @GeneratedValue
    @Column(name = "CTR_DETAILS_ID")
    private Integer contractDetailsID;

    @Column(name = "CTR_CONTRACT_ID")
    private Integer contractID;

    @Column(name = "CTR_VALID_FROM")
    private Date validFrom;

    @Column(name = "CTR_VALID_TO")
    private Date validTo;

    @Column(name = "CTR_RM_TYPE_ID")
    private Integer roomTypeID;

    @Column(name = "CTR_NO_OF_ROOMS")
    private Integer numberOfRooms;

    @Column(name = "CTR_MAX_ADULTS")
    private Integer maxAdults;

    @Column(name = "CTR_PRICE")
    private Double price;

    public Integer getContractDetailsID() {
        return contractDetailsID;
    }

    public void setContractDetailsID(Integer contractDetailsID) {
        this.contractDetailsID = contractDetailsID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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

    public Integer getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(Integer maxAdults) {
        this.maxAdults = maxAdults;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ContractDetails{" +
                "contractDetailsID=" + contractDetailsID +
                ", contractID=" + contractID +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", roomTypeID=" + roomTypeID +
                ", numberOfRooms=" + numberOfRooms +
                ", maxAdults=" + maxAdults +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractDetails that = (ContractDetails) o;

        if (!contractDetailsID.equals(that.contractDetailsID)) return false;
        if (!contractID.equals(that.contractID)) return false;
        if (!roomTypeID.equals(that.roomTypeID)) return false;
        if (!numberOfRooms.equals(that.numberOfRooms)) return false;
        return maxAdults.equals(that.maxAdults);
    }

    @Override
    public int hashCode() {
        int result = contractDetailsID.hashCode();
        result = 31 * result + contractID.hashCode();
        result = 31 * result + roomTypeID.hashCode();
        result = 31 * result + numberOfRooms.hashCode();
        result = 31 * result + maxAdults.hashCode();
        return result;
    }
}

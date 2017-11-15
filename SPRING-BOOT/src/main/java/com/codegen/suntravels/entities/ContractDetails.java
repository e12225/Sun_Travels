package com.codegen.suntravels.entities;

import com.codegen.suntravels.entities.embeddable.ContractDetailsID;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELL on 11/15/2017.
 */
@Entity
@Table(name = "SM_CONTRACT_DETAILS", schema = "SYS", catalog = "")
public class ContractDetails {

    @EmbeddedId
    private ContractDetailsID contractDetailsID;

//    @Id
//    @Column(name = "CTR_CONTRACT_ID")
//    private Integer contractID;
//
//    @Id
//    @Column(name = "CTR_RM_TYPE_ID")
//    private Integer roomTypeID;

    @Column(name = "CTR_VALID_FROM")
    private Date validFrom;

    @Column(name = "CTR_VALID_TO")
    private Date validTo;

    @Column(name = "CTR_NO_OF_ROOMS")
    private Integer numberOfRooms;

    @Column(name = "CTR_MAX_ADULTS")
    private Integer maxAdults;

    @Column(name = "CTR_PRICE")
    private Double price;

//    public Integer getContractID() {
//        return contractID;
//    }
//
//    public void setContractID(Integer contractID) {
//        this.contractID = contractID;
//    }

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

//    public Integer getRoomTypeID() {
//        return roomTypeID;
//    }
//
//    public void setRoomTypeID(Integer roomTypeID) {
//        this.roomTypeID = roomTypeID;
//    }

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

    public ContractDetailsID getContractDetailsID() {
        return contractDetailsID;
    }

    public void setContractDetailsID(ContractDetailsID contractDetailsID) {
        this.contractDetailsID = contractDetailsID;
    }

    //    @Override
//    public String toString() {
//        return "ContractDetails{" +
//                "contractID=" + contractID +
//                ", validFrom=" + validFrom +
//                ", validTo=" + validTo +
//                ", roomTypeID=" + roomTypeID +
//                ", numberOfRooms=" + numberOfRooms +
//                ", maxAdults=" + maxAdults +
//                ", price=" + price +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ContractDetails that = (ContractDetails) o;
//
//        if (!contractID.equals(that.contractID)) return false;
//        if (!validFrom.equals(that.validFrom)) return false;
//        if (!validTo.equals(that.validTo)) return false;
//        if (!roomTypeID.equals(that.roomTypeID)) return false;
//        if (!numberOfRooms.equals(that.numberOfRooms)) return false;
//        if (!maxAdults.equals(that.maxAdults)) return false;
//        return price.equals(that.price);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = contractID.hashCode();
//        result = 31 * result + validFrom.hashCode();
//        result = 31 * result + validTo.hashCode();
//        result = 31 * result + roomTypeID.hashCode();
//        result = 31 * result + numberOfRooms.hashCode();
//        result = 31 * result + maxAdults.hashCode();
//        result = 31 * result + price.hashCode();
//        return result;
//    }
}

package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "roomTypeSeq", initialValue = 1)
@Table(name = "SM_ROOM_TYPE", schema = "SYS", catalog = "")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomTypeSeq")
    @Column(name = "RM_TYPE_ID")
    private Integer roomTypeID;

    @Column(name = "RM_TYPE_NAME")
    private String roomTypeName;

    @Column(name = "RM_NO_OF_ROOMS")
    private Integer numberOfRooms;

    @Column(name = "RM_MAX_ADULTS")
    private Integer maxAdults;

    @Column(name = "RM_PRICE")
    private Double price;

    public Integer getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(Integer roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
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
        return "RoomType{" +
                "roomTypeID=" + roomTypeID +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", maxAdults=" + maxAdults +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomType roomType = (RoomType) o;

        if (!roomTypeID.equals(roomType.roomTypeID)) return false;
        if (!roomTypeName.equals(roomType.roomTypeName)) return false;
        if (!numberOfRooms.equals(roomType.numberOfRooms)) return false;
        if (!maxAdults.equals(roomType.maxAdults)) return false;
        return price.equals(roomType.price);
    }

    @Override
    public int hashCode() {
        int result = roomTypeID.hashCode();
        result = 31 * result + roomTypeName.hashCode();
        result = 31 * result + numberOfRooms.hashCode();
        result = 31 * result + maxAdults.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}

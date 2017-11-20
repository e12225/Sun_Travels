package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_ROOM_TYPE", schema = "SYS", catalog = "")
public class RoomType {

    @Id
    @GeneratedValue
    @Column(name = "RM_TYPE_ID")
    private Integer roomTypeID;

    @Column(name = "RM_TYPE_NAME")
    private String roomTypeName;

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

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeID=" + roomTypeID +
                ", roomTypeName='" + roomTypeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomType roomType = (RoomType) o;

        if (!roomTypeID.equals(roomType.roomTypeID)) return false;
        return roomTypeName.equals(roomType.roomTypeName);
    }

    @Override
    public int hashCode() {
        int result = roomTypeID.hashCode();
        result = 31 * result + roomTypeName.hashCode();
        return result;
    }
}

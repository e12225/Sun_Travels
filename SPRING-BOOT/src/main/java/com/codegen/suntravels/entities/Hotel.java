package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "hotelSeq", initialValue = 1)
@Table(name = "SM_HOTEL", schema = "SYS", catalog = "")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelSeq")
    @Column(name = "HOTEL_ID")
    private Integer hotelID;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "HOTEL_PHONE_NO")
    private String hotelPhoneNumber;

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhoneNumber='" + hotelPhoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (!hotelID.equals(hotel.hotelID)) return false;
        if (!hotelName.equals(hotel.hotelName)) return false;
        return hotelPhoneNumber != null ? hotelPhoneNumber.equals(hotel.hotelPhoneNumber) : hotel.hotelPhoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = hotelID.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + (hotelPhoneNumber != null ? hotelPhoneNumber.hashCode() : 0);
        return result;
    }
}

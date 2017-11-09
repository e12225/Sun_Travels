package main.java.codegen.sunTravels.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
@Entity
@Table(name = "SS_HOTEL")
public class Hotel {

    @Id
    @Column(name = "HOTEL_ID")
    String hotelID;
    @Column(name = "HOTEL_NAME")
    String hotelName;
    @Column(name = "HOTEL_ADDRESS")
    String hotelAddress;
    @Column(name = "HOTEL_TELEPHONE_NUMBER")
    String hotelPhoneNumber;

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public Hotel(String hotelID, String hotelName, String hotelAddress, String hotelPhoneNumber) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID='" + hotelID + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
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
        return hotelAddress.equals(hotel.hotelAddress);
    }

    @Override
    public int hashCode() {
        int result = hotelID.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + hotelAddress.hashCode();
        return result;
    }
}

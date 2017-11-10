package codegen.sunTravels.Entities;

import javax.persistence.*;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
@Entity
@Table(name = "SS_HOTEL", schema = "SYSTEM", catalog = "")
public class Hotel {

    @Id
    @GeneratedValue
    @Column(name = "HOTEL_ID")
    Integer hotelID;

    @Basic
    @Column(name = "HOTEL_NAME")
    String hotelName;

    @Basic
    @Column(name = "HOTEL_ADDRESS")
    String hotelAddress;

    @Basic
    @Column(name = "HOTEL_TELEPHONE_NUMBER")
    String hotelPhoneNumber;

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

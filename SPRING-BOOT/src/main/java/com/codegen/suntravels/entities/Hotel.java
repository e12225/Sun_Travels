package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_HOTEL", schema = "SYS", catalog = "")
public class Hotel {

    @Id
    @GeneratedValue
    @Column(name = "HOTEL_ID")
    private Integer hotelID;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "HOTEL_PHONE_NO")
    private Long hotelPhoneNumber;

    @Column(name = "HOTEL_COUNTRY_ID")
    private Integer countryID;

    @Column(name = "HOTEL_CITY_ID")
    private Integer cityID;

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

    public Long getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(Long hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhoneNumber=" + hotelPhoneNumber +
                ", countryID=" + countryID +
                ", cityID=" + cityID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (!hotelID.equals(hotel.hotelID)) return false;
        if (!hotelName.equals(hotel.hotelName)) return false;
        if (hotelPhoneNumber != null ? !hotelPhoneNumber.equals(hotel.hotelPhoneNumber) : hotel.hotelPhoneNumber != null)
            return false;
        if (!countryID.equals(hotel.countryID)) return false;
        return cityID.equals(hotel.cityID);

    }

    @Override
    public int hashCode() {
        int result = hotelID.hashCode();
        result = 31 * result + hotelName.hashCode();
        result = 31 * result + (hotelPhoneNumber != null ? hotelPhoneNumber.hashCode() : 0);
        result = 31 * result + countryID.hashCode();
        result = 31 * result + cityID.hashCode();
        return result;
    }
}

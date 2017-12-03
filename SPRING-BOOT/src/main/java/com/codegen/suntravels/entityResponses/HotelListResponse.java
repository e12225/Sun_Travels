package com.codegen.suntravels.entityResponses;

/**
 * Created by DELL on 12/2/2017.
 */
public class HotelListResponse {

    private Integer hotelID;
    private String hotelName;
    private Long hotelPhoneNumber;
    private String countryName;
    private String cityName;

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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "HotelListResponse{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhoneNumber=" + hotelPhoneNumber +
                ", countryName=" + countryName +
                ", cityName=" + cityName +
                '}';
    }
}

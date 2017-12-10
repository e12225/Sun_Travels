package com.codegen.suntravels.entityResponses;

/**
 * Created by DELL on 12/9/2017.
 */
public class CityListResponse {

    private Integer cityID;
    private String countryName;
    private String cityName;

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
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
        return "CityListResponse{" +
                "cityID=" + cityID +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

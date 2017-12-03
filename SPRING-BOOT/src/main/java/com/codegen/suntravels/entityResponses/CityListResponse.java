package com.codegen.suntravels.entityResponses;

/**
 * Created by DELL on 12/2/2017.
 */
public class CityListResponse {

    private Integer cityID;
    private String cityName;
    private String countryName;

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CityListResponse{" +
                "cityID=" + cityID +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}

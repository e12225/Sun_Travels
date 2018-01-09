package com.codegen.suntravels.entityRequests;

/**
 * Created by DELL on 12/9/2017.
 */
public class AddCityRequest
{

    private String countryName;
    private String cityName;

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName( String countryName )
    {
        this.countryName = countryName;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName( String cityName )
    {
        this.cityName = cityName;
    }

    @Override
    public String toString()
    {
        return "AddCityRequest{" +
                "countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

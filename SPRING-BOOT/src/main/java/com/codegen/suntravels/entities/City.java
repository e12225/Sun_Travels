package com.codegen.suntravels.entities;

import javax.persistence.*;

/**
 * Created by DELL on 11/18/2017.
 */
@Entity
@Table(name = "SM_CITY", schema = "SYS", catalog = "")
public class City
{

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID")
    private Integer cityID;

    @Column(name = "CITY_COUNTRY_ID")
    private Integer countryID;

    @Column(name = "CITY_NAME")
    private String cityName;

    public Integer getCityID()
    {
        return cityID;
    }

    public void setCityID( Integer cityID )
    {
        this.cityID = cityID;
    }

    public Integer getCountryID()
    {
        return countryID;
    }

    public void setCountryID( Integer countryID )
    {
        this.countryID = countryID;
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
        return "City{" +
                "cityID=" + cityID +
                ", countryID=" + countryID +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o )
        {
            return true;
        }
        if( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        City city = (City) o;

        if( !cityID.equals( city.cityID ) )
        {
            return false;
        }
        if( !countryID.equals( city.countryID ) )
        {
            return false;
        }
        return cityName.equals( city.cityName );

    }

    @Override
    public int hashCode()
    {
        int result = cityID.hashCode();
        result = 31 * result + countryID.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }
}

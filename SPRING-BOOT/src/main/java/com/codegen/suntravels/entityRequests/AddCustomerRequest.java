package com.codegen.suntravels.entityRequests;

/**
 * Created by DELL on 12/2/2017.
 */
public class AddCustomerRequest
{

    private String customerFirstName;
    private String customerLastName;
    private Long customerPhoneNumber;
    private String countryName;
    private String cityName;
    private String ssnOrNic;

    public String getCustomerFirstName()
    {
        return customerFirstName;
    }

    public void setCustomerFirstName( String customerFirstName )
    {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName()
    {
        return customerLastName;
    }

    public void setCustomerLastName( String customerLastName )
    {
        this.customerLastName = customerLastName;
    }

    public Long getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber( Long customerPhoneNumber )
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }

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

    public String getSsnOrNic()
    {
        return ssnOrNic;
    }

    public void setSsnOrNic( String ssnOrNic )
    {
        this.ssnOrNic = ssnOrNic;
    }

    @Override
    public String toString()
    {
        return "AddCustomerRequest{" +
                "customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerPhoneNumber=" + customerPhoneNumber +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", ssnOrNic=" + ssnOrNic +
                '}';
    }
}

package com.codegen.suntravels.entityRequests;

public class AddContractRequest {

    private String hotelName;

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    @Override public String toString()
    {
        return "AddContractRequest{" +
                "hotelName='" + hotelName + '\'' +
                '}';
    }
}

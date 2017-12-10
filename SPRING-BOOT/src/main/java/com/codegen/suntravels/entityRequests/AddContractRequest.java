package com.codegen.suntravels.entityRequests;

public class AddContractRequest {

    private String hotelName;
    private Long hotelPhoneNumber;

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public Long getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(Long hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    @Override
    public String toString() {
        return "AddContractRequest{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelPhoneNumber=" + hotelPhoneNumber +
                '}';
    }
}

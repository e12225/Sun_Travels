package com.codegen.suntravels.entityResponses;

public class ContractListResponse {

    private Integer contractID;
    private String hotelName;

    public Integer getContractID()
    {
        return contractID;
    }

    public void setContractID( Integer contractID )
    {
        this.contractID = contractID;
    }

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
        return "ContractListResponse{" +
                "contractID=" + contractID +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}

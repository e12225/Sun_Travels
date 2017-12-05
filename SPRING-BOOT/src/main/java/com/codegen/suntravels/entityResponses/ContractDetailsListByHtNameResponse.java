package com.codegen.suntravels.entityResponses;

public class ContractDetailsListByHtNameResponse
{
    private ContractDetailsListResponse contractDetailsListResponse;
    private String hotelName;

    public ContractDetailsListResponse getContractDetailsListResponse()
    {
        return contractDetailsListResponse;
    }

    public void setContractDetailsListResponse( ContractDetailsListResponse contractDetailsListResponse )
    {
        this.contractDetailsListResponse = contractDetailsListResponse;
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
        return "ContractDetailsListByHtNameResponse{" +
                "contractDetailsListResponse=" + contractDetailsListResponse +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}

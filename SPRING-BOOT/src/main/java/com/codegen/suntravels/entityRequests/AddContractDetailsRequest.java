package com.codegen.suntravels.entityRequests;

import java.sql.Date;

public class AddContractDetailsRequest {

    private Integer contractID;
    private Date validFrom;
    private Date validTo;
    private String roomType;
    private Integer numberOfRooms;
    private Integer maxAdults;
    private Double price;

    public Integer getContractID()
    {
        return contractID;
    }

    public void setContractID( Integer contractID )
    {
        this.contractID = contractID;
    }

    public Date getValidFrom()
    {
        return validFrom;
    }

    public void setValidFrom( Date validFrom )
    {
        this.validFrom = validFrom;
    }

    public Date getValidTo()
    {
        return validTo;
    }

    public void setValidTo( Date validTo )
    {
        this.validTo = validTo;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType( String roomType )
    {
        this.roomType = roomType;
    }

    public Integer getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public void setNumberOfRooms( Integer numberOfRooms )
    {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getMaxAdults()
    {
        return maxAdults;
    }

    public void setMaxAdults( Integer maxAdults )
    {
        this.maxAdults = maxAdults;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice( Double price )
    {
        this.price = price;
    }

    @Override public String toString()
    {
        return "AddContractDetailsRequest{" +
                "contractID=" + contractID +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", roomType='" + roomType + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", maxAdults=" + maxAdults +
                ", price=" + price +
                '}';
    }
}

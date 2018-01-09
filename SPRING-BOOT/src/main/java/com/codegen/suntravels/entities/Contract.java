package com.codegen.suntravels.entities;

import javax.persistence.*;

/**
 * Created by DELL on 11/15/2017.
 */
@Entity
@Table(name = "SM_CONTRACT", schema = "SYS", catalog = "")
public class Contract
{

    @Id
    @GeneratedValue
    @Column(name = "CTR_ID")
    private Integer contractID;

    @Column(name = "CTR_HOTEL_ID")
    private Integer hotelID;

    public Integer getContractID()
    {
        return contractID;
    }

    public void setContractID( Integer contractID )
    {
        this.contractID = contractID;
    }

    public Integer getHotelID()
    {
        return hotelID;
    }

    public void setHotelID( Integer hotelID )
    {
        this.hotelID = hotelID;
    }

    @Override
    public String toString()
    {
        return "Contract{" +
                "contractID=" + contractID +
                ", hotelID=" + hotelID +
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

        Contract contract = (Contract) o;

        if( !contractID.equals( contract.contractID ) )
        {
            return false;
        }
        return hotelID.equals( contract.hotelID );

    }

    @Override
    public int hashCode()
    {
        int result = contractID.hashCode();
        result = 31 * result + hotelID.hashCode();
        return result;
    }
}

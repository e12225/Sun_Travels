package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entityRequests.AddContractRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.ContractListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Service
public class ContractService
{

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private HotelDAO hotelDAO;

    public List<ContractListResponse> getContractList()
    {
        /**
         * Currently existing contract list
         */
        List<Contract> list = contractDAO.getContractList();

        List<ContractListResponse> response = new ArrayList<>();

        for( Contract c : list )
        {
            ContractListResponse r = new ContractListResponse();

            r.setContractID( c.getContractID() );
            r.setHotelName( hotelDAO.getHotelByID( c.getHotelID() ).getHotelName() );
            response.add( r );
        }

        return response;
    }

    public ContractListResponse getContractByID( Integer contractID )
    {
        ContractListResponse response = new ContractListResponse();

        Contract contract = contractDAO.getContractByID( contractID );

        response.setContractID( contract.getContractID() );
        response.setHotelName( hotelDAO.getHotelByID( contract.getHotelID() ).getHotelName() );

        return response;
    }

    public List<ContractListResponse> getContractByHotelID( Integer hotelID )
    {

        List<ContractListResponse> response = new ArrayList<>();

        List<Contract> list = contractDAO.getContractByHotelID( hotelID );

        for( Contract c : list )
        {
            ContractListResponse r = new ContractListResponse();

            r.setContractID( c.getContractID() );
            r.setHotelName( hotelDAO.getHotelByID( hotelID ).getHotelName() );
            response.add( r );
        }

        return response;
    }

    public List<ContractListResponse> getContractByHotelName( String hotelName )
    {

        List<ContractListResponse> response = new ArrayList<>();

        List<Hotel> htList = hotelDAO.getHotelByNameOrAlias( hotelName );

        List<Contract> ctrList = new ArrayList<>();

        for( Hotel h : htList )
        {
            List<Contract> ctr = contractDAO.getContractByHotelID( h.getHotelID() );
            ctrList.addAll( ctr );
        }

        for( Contract ctr : ctrList )
        {

            ContractListResponse r = new ContractListResponse();

            r.setContractID( ctr.getContractID() );
            r.setHotelName( hotelDAO.getHotelByID( ctr.getHotelID() ).getHotelName() );
            response.add( r );
        }

        return response;
    }

    public AddEntityResponse addContract( AddContractRequest request )
    {

        AddEntityResponse response = new AddEntityResponse();

        Hotel ht = hotelDAO.getHotelByName( request.getHotelName() );

        if( ht == null )
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A hotel named " + request.getHotelName() + " doesn't exist in the system" );
        }

        else
        {
            Contract contract = new Contract();
            contract.setHotelID( ht.getHotelID() );

            contractDAO.addContract( contract );

            response.setInsertingStatus( true );
            response.setEntity( contract );
            response.setMessage( "A new contract under " + ht.getHotelName() + " is successfully added to the system" );
        }

        return response;
    }

}

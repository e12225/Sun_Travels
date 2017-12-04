package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.entityDAO.RoomTypeDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.entityRequests.AddContractDetailsRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.ContractDetailsListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Service
public class ContractDetailsService
{

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    public List<ContractDetailsListResponse> getContractDetailsList()
    {
        /**
         * Currently existing contract details list
         */
        List<ContractDetails> list = contractDetailsDAO.getContractDetailsList();

        List<ContractDetailsListResponse> response = new ArrayList<>();

        for( ContractDetails ctr : list )
        {
            ContractDetailsListResponse r = new ContractDetailsListResponse();

            r.setContractDetailsID( ctr.getContractDetailsID() );
            r.setContractID( ctr.getContractID() );
            r.setValidFrom( ctr.getValidFrom() );
            r.setValidTo( ctr.getValidTo() );
            r.setRoomType( roomTypeDAO.getRoomTypeByID( ctr.getRoomTypeID() ).getRoomTypeName() );
            r.setNumberOfRooms( ctr.getNumberOfRooms() );
            r.setMaxAdults( ctr.getMaxAdults() );
            r.setPrice( ctr.getPrice() );
            response.add( r );
        }

        return response;
    }

    public List<ContractDetailsListResponse> getCtrDetailsByCtrID( Integer contractID )
    {
        List<ContractDetails> list = contractDetailsDAO.getCtrDetailsByCtrID( contractID );

        List<ContractDetailsListResponse> response = new ArrayList<>();

        for( ContractDetails ctr : list )
        {
            ContractDetailsListResponse r = new ContractDetailsListResponse();

            r.setContractDetailsID( ctr.getContractDetailsID() );
            r.setContractID( ctr.getContractID() );
            r.setValidFrom( ctr.getValidFrom() );
            r.setValidTo( ctr.getValidTo() );
            r.setRoomType( roomTypeDAO.getRoomTypeByID( ctr.getRoomTypeID() ).getRoomTypeName() );
            r.setNumberOfRooms( ctr.getNumberOfRooms() );
            r.setMaxAdults( ctr.getMaxAdults() );
            r.setPrice( ctr.getPrice() );
            response.add( r );
        }

        return response;
    }

    public AddEntityResponse addContractDetails( AddContractDetailsRequest request )
    {

        AddEntityResponse response = new AddEntityResponse();

        Contract ct = contractDAO.getContractByID( request.getContractID() );
        RoomType rt = roomTypeDAO.getRoomTypeByName( request.getRoomType() );

        if( ct == null )
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A contract with ID " + request.getContractID() + " doesn't exist in the system" );
        }
        else if( rt == null )
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A room type named " + request.getRoomType() + " doesn't exist in the system" );
        }
        else
        {
            /**
             * Currently existing contract details list
             */
            List<ContractDetails> list = contractDetailsDAO.getContractDetailsList();

            ContractDetails contractDetails = new ContractDetails();

            Integer nextCheckPoint = 0;
            for( ContractDetails cd : list )
            {

                if( cd.getContractID().equals( ct.getContractID() ) && cd.getRoomTypeID().equals( rt.getRoomTypeID() ) )
                {
                    // same room type cannot be added more than once under the same contract
                    response.setInsertingStatus( false );
                    response.setEntity( null );
                    response.setMessage( "A contract detail entry is already exists for the " + rt.getRoomTypeName() + " under the contract ID " + ct.getContractID() );
                    break;
                }
                else
                {
                    nextCheckPoint++;
                }
            }

            if( nextCheckPoint == list.size() )
            {
                contractDetails.setContractID( ct.getContractID() );
                contractDetails.setValidFrom( request.getValidFrom() );
                contractDetails.setValidTo( request.getValidTo() );
                contractDetails.setRoomTypeID( rt.getRoomTypeID() );
                contractDetails.setNumberOfRooms( request.getNumberOfRooms() );
                contractDetails.setMaxAdults( request.getMaxAdults() );
                contractDetails.setPrice( request.getPrice() );

                contractDetailsDAO.addContractDetails( contractDetails );

                response.setInsertingStatus( true );
                response.setEntity( contractDetails );
                response.setMessage( "A new contract detail entry successfully added to the system" );
            }
        }
        return response;
    }

    public ContractDetails getCtrDetailsByCtrIDnRmTypeID( Integer contractID, Integer roomTypeID )
    {
        return this.contractDetailsDAO.getCtrDetailsByCtrIDnRmTypeID( contractID, roomTypeID );
    }
}

package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.DAO.entityDAO.RoomTypeDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.entityRequests.AddContractDetailsRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.ContractDetailsListByHtNameResponse;
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

    @Autowired
    private HotelDAO hotelDAO;

    public List<ContractDetailsListResponse> getContractDetailsList()
    {

        List<ContractDetailsListResponse> response = new ArrayList<>();

        /**
         * Currently existing contract details list
         */
        List<ContractDetails> list = contractDetailsDAO.getContractDetailsList();

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

        List<ContractDetailsListResponse> response = new ArrayList<>();

        List<ContractDetails> list = contractDetailsDAO.getCtrDetailsByCtrID( contractID );

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

    public List<ContractDetailsListResponse> getContractDetailsByRoomTypeNameOrAlias( String roomType)
    {

        List<ContractDetailsListResponse> response = new ArrayList<>();

        List<RoomType> rmTypeList = roomTypeDAO.getRoomTypeByNameOrAlias(roomType);

        List<ContractDetails> ctrList = new ArrayList<>(  );

        for(RoomType rt : rmTypeList){
            List<ContractDetails> ctr = contractDetailsDAO.getCtrDetailsByRoomTypeID( rt.getRoomTypeID() );
            ctrList.addAll( ctr );
        }

        for( ContractDetails ctr : ctrList )
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

    public List<ContractDetailsListByHtNameResponse> getContractDetailsByHotelName( String hotelName){

        List<ContractDetailsListByHtNameResponse> response = new ArrayList<>();

        List<Hotel> htList = hotelDAO.getHotelByNameOrAlias( hotelName );

        for( Hotel h : htList ){

            List<Contract> cList = contractDAO.getContractByHotelID( h.getHotelID() );

            for(Contract ct : cList){

                List<ContractDetails> cdList = contractDetailsDAO.getCtrDetailsByCtrID( ct.getContractID() );

                for( ContractDetails cd : cdList ){

                    ContractDetailsListResponse cdr = new ContractDetailsListResponse();

                    cdr.setContractDetailsID( cd.getContractDetailsID() );
                    cdr.setContractID( ct.getContractID() );
                    cdr.setValidFrom( cd.getValidFrom() );
                    cdr.setValidTo( cd.getValidTo() );
                    cdr.setRoomType( roomTypeDAO.getRoomTypeByID( cd.getRoomTypeID() ).getRoomTypeName() );
                    cdr.setNumberOfRooms( cd.getNumberOfRooms() );
                    cdr.setMaxAdults( cd.getMaxAdults() );
                    cdr.setPrice( cd.getPrice() );

                    ContractDetailsListByHtNameResponse r = new ContractDetailsListByHtNameResponse();
                    r.setContractDetailsListResponse( cdr );
                    r.setHotelName( h.getHotelName() );
                    response.add(r);
                }
            }
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
}

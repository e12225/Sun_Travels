package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.RoomTypeDAO;
import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService
{

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    public List<RoomType> getRoomTypeList()
    {
        return this.roomTypeDAO.getRoomTypeList();
    }

    public RoomType getRoomTypeByID( Integer roomTypeID )
    {
        return this.roomTypeDAO.getRoomTypeByID( roomTypeID );
    }

    public List<RoomType> getRoomTypeByNameOrAlias( String roomTypeName )
    {
        return this.roomTypeDAO.getRoomTypeByNameOrAlias( roomTypeName );
    }

    public AddEntityResponse addRoomType( RoomType roomType )
    {

        AddEntityResponse response = new AddEntityResponse();

        RoomType rt = roomTypeDAO.getRoomTypeByName( roomType.getRoomTypeName() );

        if( rt != null )
        {
            /**
             * a room type under the given name already exists
             */
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A room type named " + roomType.getRoomTypeName() + " already exists in the system" );
        }
        else
        {
            roomTypeDAO.addRoomType( roomType );

            response.setInsertingStatus( true );
            response.setEntity( roomType );
            response.setMessage( "A new room type successfully added to the system" );
        }

        return response;
    }
}

package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.services.entityServices.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "roomTypes")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<RoomType> getRoomTypeList(){
        return roomTypeService.getRoomTypeList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{roomTypeID}")
    public RoomType getRoomTypeByID( @PathVariable("roomTypeID") Integer roomTypeID){
        return roomTypeService.getRoomTypeByID(roomTypeID);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByName/{roomTypeName}")
    public List<RoomType> getRoomTypeByNameOrAlias(@PathVariable("roomTypeName") String roomTypeName){
        return roomTypeService.getRoomTypeByNameOrAlias( roomTypeName );
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addRoomType( @RequestBody RoomType roomType){
        return roomTypeService.addRoomType(roomType);
    }
}

package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.services.entityServices.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
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
    public RoomType getRoomTypeByID(@PathParam("roomTypeID") Integer roomTypeID){
        return roomTypeService.getRoomTypeByID(roomTypeID);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addRoomType(@RequestBody RoomType roomType){
        roomTypeService.addRoomType(roomType);
    }

}

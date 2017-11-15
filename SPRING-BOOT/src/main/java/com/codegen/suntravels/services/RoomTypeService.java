package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.RoomTypeDAO;
import com.codegen.suntravels.entities.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    private RoomTypeDAO roomTypeDAO;

    public List<RoomType> getRoomTypeList(){
        return this.roomTypeDAO.getRoomTypeList();
    }

    public void addRoomType(RoomType roomType){
        this.roomTypeDAO.addRoomType(roomType);
    }
}

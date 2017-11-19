package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.RoomType;
import com.codegen.suntravels.repositories.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomTypeDAO {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getRoomTypeList(){
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeByID(Integer rmmTypeID){
        return roomTypeRepository.getRoomTypeByID(rmmTypeID);
    }

    public void addRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

}

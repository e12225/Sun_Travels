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

    public RoomType getRoomTypeByID(Integer roomTypeID){
        return roomTypeRepository.getRoomTypeByID(roomTypeID);
    }

    public RoomType getRoomTypeByName(String roomTypeName){
        return roomTypeRepository.getRoomTypeByName(roomTypeName);
    }

    public List<RoomType> getRoomTypeByNameOrAlias(String roomTypeName){
        return roomTypeRepository.getRoomTypeByNameOrAlias( roomTypeName );
    }

    public void addRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

}

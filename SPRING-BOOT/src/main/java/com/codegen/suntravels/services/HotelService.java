package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.HotelDAO;
import com.codegen.suntravels.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    public List<Hotel> getHotelsList(){
        return this.hotelDAO.getHotelsList();
    }

    public void addHotel(Hotel hotel){
        this.hotelDAO.addHotel(hotel);
    }
}

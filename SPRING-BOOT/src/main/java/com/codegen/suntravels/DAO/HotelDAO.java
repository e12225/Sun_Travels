package com.codegen.suntravels.DAO;

import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelDAO {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotelList(){
        return hotelRepository.findAll();
    }

    public void addHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }
}

package main.java.codegen.sunTravels.Services;

import main.java.codegen.sunTravels.Entities.Hotel;

import java.util.List;

/**
 * Created by DELL on 11/9/2017.
 */
public interface HotelService {

    void addHotel(Hotel hotel);
    List<Hotel> getHotelList();
}

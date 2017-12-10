package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelDAO {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getHotelList() {
        return hotelRepository.findAll();
    }

    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Hotel getHotelByID(Integer hotelID) {
        return hotelRepository.getHotelByID(hotelID);
    }

    public Hotel getHotelByNameandPhoneNumber(String hotelName, Long phoneNumber) {
        return hotelRepository.getHotelByNameandPhoneNumber(hotelName, phoneNumber);
    }

    public Hotel getHotelByNameCityCountry(String hotelName, Integer cityID, Integer countryID) {
        return hotelRepository.getHotelByNameCityCountry(hotelName, cityID, countryID);
    }

    public List<Hotel> getHotelByNameOrAlias(String hotelName) {
        return hotelRepository.getHotelByNameOrAlias(hotelName);
    }

    public Hotel getHotelByPhoneNumber(Long phoneNumber) {
        return hotelRepository.getHotelByPhoneNumber(phoneNumber);
    }
}

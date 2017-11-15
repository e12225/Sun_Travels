package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Hotel> getHotelList(){
        return hotelService.getHotelList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
    }
}
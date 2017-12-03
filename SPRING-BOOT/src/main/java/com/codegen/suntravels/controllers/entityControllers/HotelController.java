package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entityRequests.AddHotelRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.HotelListResponse;
import com.codegen.suntravels.services.entityServices.CityService;
import com.codegen.suntravels.services.entityServices.CountryService;
import com.codegen.suntravels.services.entityServices.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<HotelListResponse> getHotelList() {
        return hotelService.getHotelList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{hotelID}")
    public HotelListResponse getHotelByID(@PathVariable("hotelID") Integer hotelID) {
        return hotelService.getHotelByID(hotelID);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addHotel(@RequestBody AddHotelRequest request) {
        return hotelService.addHotel(request);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByName/{hotelName}")
    public List<HotelListResponse> getHotelByNameOrAlias(@PathVariable("hotelName") String hotelName){
        return hotelService.getHotelByNameOrAlias(hotelName);
    }
}

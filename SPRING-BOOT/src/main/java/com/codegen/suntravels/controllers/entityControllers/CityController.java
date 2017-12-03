package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.entityResponses.CityListResponse;
import com.codegen.suntravels.services.entityServices.CityService;
import com.codegen.suntravels.services.entityServices.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<CityListResponse> getCityList(){

        List<CityListResponse> response = new ArrayList<>();

        List<City> list = cityService.getCityList();

        for(City city : list){

            CityListResponse r = new CityListResponse();

            r.setCityID(city.getCityID());
            r.setCityName(city.getCityName());
            r.setCountryName(countryService.getCountryByID(city.getCountryID()).getCountryName());
            response.add(r);
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }
}

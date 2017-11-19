package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.services.entityServices.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<City> getCityList(){
        return cityService.getCityList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addCity(City city){
        cityService.addCity(city);
    }
}

package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.services.entityServices.CityService;
import com.codegen.suntravels.services.entityServices.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<City> getCityList(){
        return cityService.getCityList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }
}

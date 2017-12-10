package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entityRequests.AddCityRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.CityListResponse;
import com.codegen.suntravels.services.entityServices.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<CityListResponse> getCityList() {
        return cityService.getCityList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByName/{cityName}")
    public List<CityListResponse> getCityByNameOrAlias(@PathVariable("cityName") String cityName) {
        return cityService.getCityByNameOrAlias(cityName);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addCity(@RequestBody AddCityRequest request) {
        return cityService.addCity(request);
    }
}
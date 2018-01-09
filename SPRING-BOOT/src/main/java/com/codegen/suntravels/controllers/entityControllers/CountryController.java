package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.services.entityServices.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@RestController
@RequestMapping("countries")
public class CountryController
{

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Country> getCountryList()
    {
        return countryService.getCountryList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByName/{countryName}")
    public List<Country> getCountryByNameOrAlias( @PathVariable("countryName") String countryName )
    {
        return countryService.getCountryByNameOrAlias( countryName );
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addCountry( @RequestBody Country country )
    {
        return countryService.addCountry( country );
    }
}

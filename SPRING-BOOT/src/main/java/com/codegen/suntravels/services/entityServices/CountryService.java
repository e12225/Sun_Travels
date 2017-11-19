package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Service
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    public List<Country> getCountryList(){
        return this.countryDAO.getCountryList();
    }

    public void addCountry(Country country){
        this.countryDAO.addCountry(country);
    }
}

package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Component
public class CountryDAO {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryList(){
        return countryRepository.findAll();
    }

    public void addCountry(Country country){
        countryRepository.save(country);
    }
}

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
public class CountryDAO
{

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountryList()
    {
        return countryRepository.findAll();
    }

    public Country getCountryByID( Integer countryID )
    {
        return countryRepository.getCountryByID( countryID );
    }

    public Country getCountryByName( String countryName )
    {
        return countryRepository.getCountryByName( countryName );
    }

    public List<Country> getCountryByNameOrAlias( String countryName )
    {
        return countryRepository.getCountryByNameOrAlias( countryName );
    }

    public void addCountry( Country country )
    {
        countryRepository.save( country );
    }
}

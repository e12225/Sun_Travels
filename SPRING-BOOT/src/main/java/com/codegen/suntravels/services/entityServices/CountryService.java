package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Service
public class CountryService
{

    @Autowired
    private CountryDAO countryDAO;

    public List<Country> getCountryList()
    {
        return this.countryDAO.getCountryList();
    }

    public Country getCountryByID( Integer countryID )
    {
        return this.countryDAO.getCountryByID( countryID );
    }

    public List<Country> getCountryByNameOrAlias( String countryName )
    {
        return this.countryDAO.getCountryByNameOrAlias( countryName );
    }

    public AddEntityResponse addCountry( Country country )
    {

        AddEntityResponse response = new AddEntityResponse();

        Country co = countryDAO.getCountryByName( country.getCountryName() );

        if( co != null )
        {
            /**
             * a country under the given name already exists
             */
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A country named " + country.getCountryName() + " already exists in the system" );
        }
        else
        {
            countryDAO.addCountry( country );

            response.setInsertingStatus( true );
            response.setEntity( country );
            response.setMessage( "A new country successfully added to the system" );
        }

        return response;
    }
}

package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CityDAO;
import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.entityRequests.AddCityRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.CityListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Service
public class CityService
{

    @Autowired
    private CityDAO cityDAO;

    @Autowired
    private CountryDAO countryDAO;

    public List<CityListResponse> getCityList()
    {

        List<CityListResponse> response = new ArrayList<>();

        List<City> list = cityDAO.getCityList();

        for( City city : list )
        {
            CityListResponse r = new CityListResponse();

            r.setCityID( city.getCityID() );
            r.setCityName( city.getCityName() );
            r.setCountryName( countryDAO.getCountryByID( city.getCountryID() ).getCountryName() );
            response.add( r );
        }

        return response;
    }

    public City getCityByID( Integer cityID )
    {
        return this.cityDAO.getCityByID( cityID );
    }

    public List<CityListResponse> getCityByNameOrAlias( String name )
    {

        List<CityListResponse> response = new ArrayList<>();

        List<City> list = cityDAO.getCityByNameOrAlias( name );

        for( City city : list )
        {
            CityListResponse r = new CityListResponse();

            r.setCityID( city.getCityID() );
            r.setCityName( city.getCityName() );
            r.setCountryName( countryDAO.getCountryByID( city.getCountryID() ).getCountryName() );
            response.add( r );
        }

        return response;
    }

    public AddEntityResponse addCity( AddCityRequest request )
    {

        AddEntityResponse response = new AddEntityResponse();

        Country co = countryDAO.getCountryByName( request.getCountryName() );

        if( co != null )
        {

            City ci = cityDAO.getCityBelongstoGivenCountry( co.getCountryID(), request.getCityName() );

            if( ci != null )
            {
                response.setInsertingStatus( false );
                response.setEntity( null );
                response.setMessage( "A city named " + request.getCityName() + " under the given country named " + request.getCountryName() + " already exists in the system" );
            }
            else
            {
                City city = new City();
                city.setCityName( request.getCityName() );
                city.setCountryID( co.getCountryID() );

                cityDAO.addCity( city );

                response.setInsertingStatus( true );
                response.setEntity( city );
                response.setMessage( "A new city successfully added to the system" );
            }
        }
        else
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A country named " + request.getCountryName() + " doesn't exist in the system" );
        }

        return response;
    }

    public AddEntityResponse updateCity(AddCityRequest request, Integer cityID){

        AddEntityResponse response = new AddEntityResponse();

        City ci = cityDAO.getCityByID( cityID );

        if(ci != null){

        }

        return null;
    }
}

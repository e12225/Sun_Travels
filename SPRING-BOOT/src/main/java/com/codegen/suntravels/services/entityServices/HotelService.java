package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CityDAO;
import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entityRequests.AddHotelRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.HotelListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService
{

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private CityDAO cityDAO;

    public List<HotelListResponse> getHotelList()
    {
        /**
         * Currently existing hotel list
         */
        List<Hotel> list = hotelDAO.getHotelList();

        List<HotelListResponse> response = new ArrayList<>();

        for( Hotel hotel : list )
        {
            HotelListResponse r = new HotelListResponse();

            r.setHotelID( hotel.getHotelID() );
            r.setHotelName( hotel.getHotelName() );
            r.setHotelPhoneNumber( hotel.getHotelPhoneNumber() );
            r.setCountryName( countryDAO.getCountryByID( hotel.getCountryID() ).getCountryName() );
            r.setCityName( cityDAO.getCityByID( hotel.getCityID() ).getCityName() );
            response.add( r );
        }

        return response;
    }

    public AddEntityResponse addHotel( AddHotelRequest request )
    {

        AddEntityResponse response = new AddEntityResponse();

        Country co = countryDAO.getCountryByName( request.getCountryName() );

        if( co != null )
        {

            City ci = cityDAO.getCityBelongstoGivenCountry( co.getCountryID(), request.getCityName() );

            if( ci == null )
            {
                response.setInsertingStatus( false );
                response.setEntity( null );
                response.setMessage( "A city named : " + request.getCityName() + " under the given country named : " + request.getCountryName() + " doesn't exist in the system" );
            }
            else
            {
                Hotel htP = hotelDAO.getHotelByPhoneNumber( request.getHotelPhoneNumber() );

                if( htP != null )
                {
                    response.setInsertingStatus( false );
                    response.setEntity( null );
                    response.setMessage( "A hotel already exists with the given phone number : " + request.getHotelPhoneNumber() );
                }
                else
                {
                    Hotel htX = hotelDAO.getHotelByNameCityCountry( request.getHotelName(), ci.getCityID(), co.getCountryID() );

                    if( htX != null )
                    {
                        response.setInsertingStatus( false );
                        response.setEntity( null );
                        response.setMessage( "A hotel already exists with the given hotel name : " + request.getHotelName() +
                                " ,given city name : " + request.getCityName() + " , and the given country name : " + request.getCountryName() );
                    }
                    else
                    {

                        Hotel hotel = new Hotel();

                        hotel.setHotelName( request.getHotelName() );
                        hotel.setHotelPhoneNumber( request.getHotelPhoneNumber() );
                        hotel.setCountryID( co.getCountryID() );
                        hotel.setCityID( ci.getCityID() );

                        hotelDAO.addHotel( hotel );

                        response.setInsertingStatus( true );
                        response.setEntity( hotel );
                        response.setMessage( "A new hotel successfully added to the system" );
                    }
                }
            }
        }
        else
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A country named : " + request.getCountryName() + " doesn't exist in the system" );
        }

        return response;
    }

    public HotelListResponse getHotelByID( Integer hotelID )
    {

        HotelListResponse response = new HotelListResponse();

        Hotel hotel = hotelDAO.getHotelByID( hotelID );

        response.setHotelID( hotel.getHotelID() );
        response.setHotelName( hotel.getHotelName() );
        response.setHotelPhoneNumber( hotel.getHotelPhoneNumber() );
        response.setCountryName( countryDAO.getCountryByID( hotel.getCountryID() ).getCountryName() );
        response.setCityName( cityDAO.getCityByID( hotel.getCityID() ).getCityName() );

        return response;
    }

    public List<HotelListResponse> getHotelByNameOrAlias( String name )
    {
        List<Hotel> list = hotelDAO.getHotelByNameOrAlias( name );

        List<HotelListResponse> response = new ArrayList<>();

        for( Hotel hotel : list )
        {
            HotelListResponse r = new HotelListResponse();

            r.setHotelID( hotel.getHotelID() );
            r.setHotelName( hotel.getHotelName() );
            r.setHotelPhoneNumber( hotel.getHotelPhoneNumber() );
            r.setCountryName( countryDAO.getCountryByID( hotel.getCountryID() ).getCountryName() );
            r.setCityName( cityDAO.getCityByID( hotel.getCityID() ).getCityName() );
            response.add( r );
        }

        return response;
    }
}

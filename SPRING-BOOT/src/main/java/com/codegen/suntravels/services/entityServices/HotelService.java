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
        City ci = cityDAO.getCityByName( request.getCityName() );

        if( co == null )
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A country named " + request.getCountryName() + " doesn't exist in the system" );
        }
        else if( ci == null )
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A city named " + request.getCityName() + " doesn't exist in the system" );
        }
        else
        {

            /**
             * Currently existing hotel list
             */
            List<Hotel> list = hotelDAO.getHotelList();

            Hotel hotel = new Hotel();

            Integer nextCheckPoint = 0;
            for( Hotel h : list )
            {

                if( h.getHotelPhoneNumber().equals( request.getHotelPhoneNumber() ) )
                {
                    // two hotels can't have the same phone number
                    response.setInsertingStatus( false );
                    response.setEntity( null );
                    response.setMessage( "A hotel already exists with the given phone number : " + request.getHotelPhoneNumber() );
                    break;
                }
                else if( h.getHotelName().equals( request.getHotelName() ) &&
                        cityDAO.getCityByID( h.getCityID() ).getCityName().equals( ci.getCityName() ) &&
                        countryDAO.getCountryByID( h.getCountryID() ).getCountryName().equals( co.getCountryName() ) )
                {
                    response.setInsertingStatus( false );
                    response.setEntity( null );
                    response.setMessage( "A hotel already exists with the given hotel name : " + request.getHotelName() +
                            " ,given city name : " + request.getCityName() + " , and the given country name : " + request.getCountryName() );
                    break;
                }
                else
                {
                    nextCheckPoint++;
                }
            }

            if( nextCheckPoint == list.size() )
            {

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

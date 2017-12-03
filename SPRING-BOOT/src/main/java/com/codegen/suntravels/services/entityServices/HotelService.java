package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CityDAO;
import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.DAO.entityDAO.HotelDAO;
import com.codegen.suntravels.entities.Hotel;
import com.codegen.suntravels.entityRequests.AddHotelRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.HotelListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private CityDAO cityDAO;

    public List<HotelListResponse> getHotelList() {

        /**
         * Currently existing hotel list
         */
        List<Hotel> list = hotelDAO.getHotelList();

        List<HotelListResponse> response = new ArrayList<>();

        for (Hotel hotel : list) {

            HotelListResponse r = new HotelListResponse();

            r.setHotelID(hotel.getHotelID());
            r.setHotelName(hotel.getHotelName());
            r.setHotelPhoneNumber(hotel.getHotelPhoneNumber());
            r.setCountryName(countryDAO.getCountryByID(hotel.getCountryID()).getCountryName());
            r.setCityName(cityDAO.getCityByID(hotel.getCityID()).getCityName());
            response.add(r);
        }

        return response;
    }

    public AddEntityResponse addHotel(AddHotelRequest request) {

        /**
         * Currently existing hotel list
         */
        List<Hotel> list = hotelDAO.getHotelList();

        AddEntityResponse response = new AddEntityResponse();
        Hotel hotel = new Hotel();

        Integer nextCheckPoint = 0;
        for (Hotel h : list) {

            if (h.getHotelPhoneNumber().equals(request.getHotelPhoneNumber())) {
                // two hotels can't have the same phone number
                response.setInsertingStatus(false);
                response.setEntity(null);
                response.setMessage("A hotel already exists with the given phone number : " + request.getHotelPhoneNumber());
                break;
            } else if (h.getHotelName().equals(request.getHotelName()) &&
                    cityDAO.getCityByID(h.getCityID()).getCityName().equals(request.getCityName())&&
                    countryDAO.getCountryByID(h.getCountryID()).getCountryName().equals(request.getCountryName())) {
                response.setInsertingStatus(false);
                response.setEntity(null);
                response.setMessage("A hotel already exists with the given hotel name : " + request.getHotelName() +
                        " ,given city name : " + request.getCityName() + " , and the given country name : " + request.getCountryName());
                break;
            } else {
                nextCheckPoint ++;
            }
        }

        if(nextCheckPoint == list.size()){

            hotel.setHotelName(request.getHotelName());
            hotel.setHotelPhoneNumber(request.getHotelPhoneNumber());
            hotel.setCountryID(countryDAO.getCountryByName(request.getCountryName()).getCountryID());
            hotel.setCityID(cityDAO.getCityByName(request.getCityName()).getCityID());

            hotelDAO.addHotel(hotel);

            response.setInsertingStatus(true);
            response.setEntity(hotel);
            response.setMessage("New hotel successfully added to the system");
        }

        return response;
    }

    public HotelListResponse getHotelByID(Integer hotelID) {

        HotelListResponse response = new HotelListResponse();

        Hotel hotel = hotelDAO.getHotelByID(hotelID);

        response.setHotelID(hotel.getHotelID());
        response.setHotelName(hotel.getHotelName());
        response.setHotelPhoneNumber(hotel.getHotelPhoneNumber());
        response.setCountryName(countryDAO.getCountryByID(hotel.getCountryID()).getCountryName());
        response.setCityName(cityDAO.getCityByID(hotel.getCityID()).getCityName());

        return response;
    }

    public List<HotelListResponse> getHotelByName(String name) {

        /**
         * Currently existing hotel list
         */
        List<Hotel> list = hotelDAO.getHotelByName(name);

        List<HotelListResponse> response = new ArrayList<>();

        for (Hotel hotel : list) {

            HotelListResponse r = new HotelListResponse();

            r.setHotelID(hotel.getHotelID());
            r.setHotelName(hotel.getHotelName());
            r.setHotelPhoneNumber(hotel.getHotelPhoneNumber());
            r.setCountryName(countryDAO.getCountryByID(hotel.getCountryID()).getCountryName());
            r.setCityName(cityDAO.getCityByID(hotel.getCityID()).getCityName());
            response.add(r);
        }

        return response;
    }
}

package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CityDAO;
import com.codegen.suntravels.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Service
public class CityService {

    @Autowired
    private CityDAO cityDAO;

    public List<City> getCityList(){
        return this.cityDAO.getCityList();
    }

    public City getCityByID(Integer cityID){
        return this.cityDAO.getCityByID(cityID);
    }

    public void addCity(City city){
        this.cityDAO.addCity(city);
    }


}

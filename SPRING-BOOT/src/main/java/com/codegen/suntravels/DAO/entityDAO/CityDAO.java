package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Component
public class CityDAO {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getCityList(){
        return cityRepository.findAll();
    }

    public void addCity(City city){
        cityRepository.save(city);
    }
}

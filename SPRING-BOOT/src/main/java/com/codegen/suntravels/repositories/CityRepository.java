package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 11/18/2017.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    /**
     * Retrieving the cities filtered by cityID
     */
    @Query("SELECT c FROM City c WHERE c.cityID = :cID")
    City getCityByID(@Param("cID") Integer cityID);

    /**
     * Retrieving the cities filtered by cityName
     */
    @Query("SELECT c FROM City c WHERE c.cityName LIKE CONCAT('%',:cName,'%')")
    City getCityByName(@Param("cName") String cityName);
}

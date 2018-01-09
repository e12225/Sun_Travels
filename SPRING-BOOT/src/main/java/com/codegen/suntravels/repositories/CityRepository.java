package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DELL on 11/18/2017.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long>
{

    /**
     * Retrieving the cities filtered by cityID
     */
    @Query("SELECT c FROM City c WHERE c.cityID = :cID")
    City getCityByID( @Param("cID") Integer cityID );

    /**
     * Retrieving the cities filtered by partial or full cityName
     */
    @Query("SELECT c FROM City c WHERE upper(c.cityName) LIKE CONCAT('%',upper(:cName),'%') OR lower(c.cityName) LIKE CONCAT('%',lower(:cName),'%')")
    List<City> getCityByNameOrAlias( @Param("cName") String cityName );

    /**
     * Retrieving the city filtered by its' country when the country ID is given
     */
    @Query("SELECT c FROM City c WHERE c.countryID = :coID AND upper(c.cityName) = upper(:cName) OR c.countryID = :coID AND lower(c.cityName) = lower(:cName)")
    City getCityBelongstoGivenCountry( @Param("coID") Integer countryID, @Param("cName") String cityName );
}

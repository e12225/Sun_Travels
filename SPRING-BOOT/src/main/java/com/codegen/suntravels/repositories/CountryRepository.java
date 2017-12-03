package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 11/18/2017.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

    /**
     * Retrieving the countries filtered by countryID
     */
    @Query("SELECT co FROM Country co WHERE co.countryID = :coID")
    Country getCountryByID(@Param("coID") Integer countryID);

    /**
     * Retrieving the countries filtered by countryName
     */
    @Query("SELECT co FROM Country co WHERE co.countryName LIKE CONCAT('%',:coName,'%')")
    Country getCountryByName(@Param("coName") String countryName);
}

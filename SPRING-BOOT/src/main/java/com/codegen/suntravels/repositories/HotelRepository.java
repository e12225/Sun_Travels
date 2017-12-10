package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Retrieving the hotels filtered by hotelID
     */
    @Query("SELECT h FROM Hotel h WHERE h.hotelID = :htID")
    Hotel getHotelByID(@Param("htID") Integer hotelID);

    /**
     * Retrieving the hotel filtered by hotelName and its' phone number
     */
    @Query("SELECT h FROM Hotel h WHERE upper(h.hotelName) = upper(:htName) AND h.hotelPhoneNumber = :htPhoneNumber OR lower(h.hotelName) = lower(:htName) AND h.hotelPhoneNumber = :htPhoneNumber")
    Hotel getHotelByNameandPhoneNumber(@Param("htName") String hotelName, @Param("htPhoneNumber") Long phoneNumber);

    /**
     * Retrieving the hotels filtered by partial or full hotelName
     */
    @Query("SELECT h FROM Hotel h WHERE upper(h.hotelName) LIKE CONCAT('%',upper(:htName),'%') OR lower(h.hotelName) LIKE CONCAT('%',lower(:htName),'%')")
    List<Hotel> getHotelByNameOrAlias(@Param("htName") String hotelName);

    /**
     * Retrieving the hotels filtered by hotel phone number
     */
    @Query("SELECT h FROM Hotel h WHERE h.hotelPhoneNumber = :htPhoneNumber")
    Hotel getHotelByPhoneNumber(@Param("htPhoneNumber") Long hotelPhoneNumber);

    /**
     * Retrieving the hotel filtered by hotelName, its' cityID and its' countryID
     */
    @Query("SELECT h FROM Hotel h WHERE (upper(h.hotelName) = upper(:htName) AND h.cityID = :htCityID AND h.countryID = :htCountryID) OR (lower(h.hotelName) = lower(:htName) AND h.cityID = :htCityID AND h.countryID = :htCountryID)")
    Hotel getHotelByNameCityCountry(@Param("htName") String hotelName, @Param("htCityID") Integer cityID, @Param("htCountryID") Integer countryID);
}

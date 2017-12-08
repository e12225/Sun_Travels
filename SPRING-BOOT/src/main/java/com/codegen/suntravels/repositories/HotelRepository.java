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
     * Retrieving the hotel filtered by hotelName
     */
    @Query("SELECT h FROM Hotel h WHERE upper(h.hotelName) = :htName OR lower(h.hotelName) = :htName")
    Hotel getHotelByName(@Param("htName") String hotelName);

    /**
     * Retrieving the hotels filtered by partial or full hotelName
     */
    @Query("SELECT h FROM Hotel h WHERE upper(h.hotelName) LIKE CONCAT('%',upper(:htName),'%') OR lower(h.hotelName) LIKE CONCAT('%',lower(:htName),'%')")
    List<Hotel> getHotelByNameOrAlias(@Param("htName") String hotelName);
}

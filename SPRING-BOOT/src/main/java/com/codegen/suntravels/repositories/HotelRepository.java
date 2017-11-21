package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Retrieving the hotels filtered by hotelID
     */
    @Query("SELECT h FROM Hotel h WHERE h.hotelID = :htID")
    Hotel getHotelByID(@Param("htID") Integer hotelID);

    /**
     * Retrieving the hotels filtered by hotelName
     */
    @Query("SELECT h FROM Hotel h WHERE h.hotelName = :htName")
    Hotel getHotelByName(@Param("htName") String hotelName);

}

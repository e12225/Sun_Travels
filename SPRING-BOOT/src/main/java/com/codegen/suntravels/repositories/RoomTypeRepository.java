package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    /**
     * Retrieving the room types filtered by roomTypeID
     */
    @Query("SELECT r FROM RoomType r WHERE r.roomTypeID = :rtID")
    RoomType getRoomTypeByID(@Param("rtID") Integer roomTypeID);

    /**
     * Retrieving the room types filtered by roomTypeName
     */
    @Query("SELECT r FROM RoomType r WHERE r.roomTypeName LIKE CONCAT('%',:rtName,'%')")
    RoomType getRoomTypeByName(@Param("rtName") String roomTypeName);
}

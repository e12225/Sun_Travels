package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    /**
     * Retrieving the room types filtered by roomTypeID
     */
    @Query("SELECT r FROM RoomType r WHERE r.roomTypeID = :rtID")
    RoomType getRoomTypeByID(@Param("rtID") Integer roomTypeID);

    /**
     * Retrieving the room type filtered by roomTypeName
     */
    @Query("SELECT r FROM RoomType r WHERE upper(r.roomTypeName) = :rtName OR lower(r.roomTypeName) = :rtName")
    RoomType getRoomTypeByName(@Param("rtName") String roomTypeName);

    /**
     * Retrieving the room types filtered by partial or full roomTypeName
     */
    @Query("SELECT r FROM RoomType r WHERE upper(r.roomTypeName) LIKE CONCAT('%',upper(:rtName),'%') OR lower(r.roomTypeName) LIKE CONCAT('%',lower(:rtName),'%')")
    List<RoomType> getRoomTypeByNameOrAlias( @Param("rtName") String roomTypeName);
}

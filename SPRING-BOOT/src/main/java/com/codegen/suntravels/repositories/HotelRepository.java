package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    //TODO : implement 'searchHotelByName()' here

}

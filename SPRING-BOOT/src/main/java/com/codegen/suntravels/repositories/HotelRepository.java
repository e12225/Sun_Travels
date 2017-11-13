package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}

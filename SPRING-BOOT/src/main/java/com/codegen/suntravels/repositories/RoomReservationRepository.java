package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {

    //TODO : implement 'findBy...()'
}

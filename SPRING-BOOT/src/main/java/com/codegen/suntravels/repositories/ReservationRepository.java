package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //TODO : implement 'searchBy...()' here
}

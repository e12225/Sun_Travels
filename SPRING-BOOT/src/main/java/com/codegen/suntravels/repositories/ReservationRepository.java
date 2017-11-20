package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * Retrieving the reservations filtered by reservationID
     */
    @Query("SELECT r FROM Reservation r WHERE r.reservationID = :resID")
    Reservation getReservationByID(@Param("resID") Integer reservationID);
}

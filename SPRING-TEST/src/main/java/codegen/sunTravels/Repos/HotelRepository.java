package codegen.sunTravels.Repos;

import codegen.sunTravels.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("select h from Hotel h where h.hotelName = :hotelName")
    Stream<Hotel> findByLetterOrName(@Param("hotelName") String hotelName);
}

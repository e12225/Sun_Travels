package codegen.sunTravels.Services;

import codegen.sunTravels.Entities.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author - Subhani
 * @Date - 11/9/2017
 */
public interface HotelService {

    void addNewHotel(Hotel hotel);

    List<Hotel> getHotelByNameOrLetter(String str);

    List<Hotel> getHotelList();
}

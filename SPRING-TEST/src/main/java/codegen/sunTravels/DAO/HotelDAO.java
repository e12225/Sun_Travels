package codegen.sunTravels.DAO;

import codegen.sunTravels.Entities.Hotel;

import java.util.List;

/**
 * @Author - Subhani
 * @Date - 11/9/2017
 */
public interface HotelDAO {

    void addHotel(Hotel hotel);

    List<Hotel> getHotelByNameOrLetter(String str);

    List<Hotel> getHotelList();
}

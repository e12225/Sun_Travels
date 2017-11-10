package codegen.sunTravels.DAO;

import codegen.sunTravels.Entities.Hotel;
import codegen.sunTravels.Repos.HotelRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author - Subhani
 * @Date - 11/9/2017
 */
@Component
public class HotelDAOImpl implements HotelDAO {

    Logger logger = Logger.getLogger(HotelDAOImpl.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void addHotel(Hotel hotel) {
        logger.info("New hotel entity is about to be persisted");
        this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelByNameOrLetter(String str) {
        logger.info("Hotel is to be returned now");
        List<Hotel> filteredHotelList = new ArrayList<>();

        Stream<Hotel> hotelStream = this.hotelRepository.findByLetterOrName(str);
        hotelStream.forEach(x ->filteredHotelList.add(x));
        return filteredHotelList;
    }

    @Override
    public List<Hotel> getHotelList() {
        logger.info("Hotel list is to be returned now");
        return this.hotelRepository.findAll();

    }
}

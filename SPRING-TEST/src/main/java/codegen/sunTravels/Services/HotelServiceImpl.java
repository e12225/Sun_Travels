package codegen.sunTravels.Services;

import codegen.sunTravels.DAO.HotelDAO;
import codegen.sunTravels.Entities.Hotel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author - Subhani
 * @Date - 11/9/2017
 */
@Service
public class HotelServiceImpl implements HotelService {

    Logger logger = Logger.getLogger(HotelServiceImpl.class);

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public void addNewHotel(Hotel hotel) {
        logger.info("DAO class addNewHotel method is called");
        this.hotelDAO.addHotel(hotel);
    }

    @Override
    public List<Hotel> getHotelByNameOrLetter(String str) {
        logger.info("DAO class getHotelListByNameOrLetter method is called");
        return this.hotelDAO.getHotelByNameOrLetter(str);
    }

    @Override
    public List<Hotel> getHotelList() {
        logger.info("DAO class getHotelList method is called");
        return this.hotelDAO.getHotelList();
    }
}

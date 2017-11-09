package main.java.codegen.sunTravels.Services;

import main.java.codegen.sunTravels.DAO.HotelDAO;
import main.java.codegen.sunTravels.Entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by DELL on 11/9/2017.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Transactional
    @Override
    public void addHotel(Hotel hotel) {
        hotelDAO.addHotel(hotel);
    }

    //@Transactional(readOnly = true)
    @Override
    public List<Hotel> getHotelList() {
        return hotelDAO.getHotelList();
    }
}

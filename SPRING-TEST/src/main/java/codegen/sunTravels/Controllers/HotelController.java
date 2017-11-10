package codegen.sunTravels.Controllers;

import codegen.sunTravels.Entities.Hotel;
import codegen.sunTravels.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * This method returns the list of existing hotels in the system
     * @return
     */
    @RequestMapping(
            value = "/allHotelsList/",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public List<Hotel> getAllHotelsList() {
        return hotelService.getHotelList();
    }

    /**
     * This method returns the the hotel(s) whose name(s) start(s) with the path variable
     * @param str
     * @return
     */
    @RequestMapping(
            value = "/hotelByName/{str}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public List<Hotel> getHotelByNameOrLetter(@PathVariable("str") String str) {
        return hotelService.getHotelByNameOrLetter(str);
    }

    /**
     * This method inserts a new hotel entity to the system
     * @param newHotel
     */
    @RequestMapping(
            value = "/addNewHotel/",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    @ResponseBody
    public void addNewHotel(@RequestBody Hotel newHotel) {
        Hotel hotel = new Hotel();
        hotel.setHotelID(newHotel.getHotelID());
        hotel.setHotelName(newHotel.getHotelName());
        hotel.setHotelAddress(newHotel.getHotelAddress());
        hotelService.addNewHotel(hotel);
    }
}

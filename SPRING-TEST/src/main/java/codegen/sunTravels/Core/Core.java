package main.java.codegen.sunTravels.Core;

import main.java.codegen.sunTravels.Config.SpringConfig;
import main.java.codegen.sunTravels.Entities.Hotel;
import main.java.codegen.sunTravels.Services.HotelService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
public class Core {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        HotelService hotelService = context.getBean(HotelService.class);

        //Add a hotel : TODO :- later these parameters should be received from the HTTP POST request.
        hotelService.addHotel(new Hotel("ASSL01", "Galadari Hotel", "GaleFace Rd,Colombo", "0112225891"));
        hotelService.addHotel(new Hotel("ASSL02", "Cinamond Grand", "Galle Rd, Colombo", "01122564879"));

        //Get hotel list
        List<Hotel> hotels = hotelService.getHotelList();
        for(Hotel hotel : hotels){
            System.out.println("HotelID : " + hotel.getHotelID());
            System.out.print("Hotel Name : " + hotel.getHotelName());
            System.out.println("Hotel Address : " + hotel.getHotelAddress());
            System.out.println("Hotel Phone Number : " + hotel.getHotelPhoneNumber());
            System.out.println();
        }

        context.close();
//
//        Hotel hotel = context.getBean("hotelBean", Hotel.class);
//
//        System.out.println(hotel);
    }
}

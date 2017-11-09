package codegen.sunTravels.Config;

import codegen.sunTravels.Entities.HotelBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
@Configuration
public class HotelConfig {

    @Bean
    public HotelBean hotelBean(){

        HotelBean hb = new HotelBean();

        /**
         * Instead of hardcoding the values here, these values should be received from the POST request
         * from the call center agent
         */
        hb.setHotelID("ASSL02");
        hb.setHotelName("Cinnamon Grand Colombo");
        hb.setHotelAddress("77 Galle Rd, Colombo 00300");
        hb.setHotelPhoneNumber("011 2 437437");

        return hb;
    }
}

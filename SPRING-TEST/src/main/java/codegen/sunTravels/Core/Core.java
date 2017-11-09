package codegen.sunTravels.Core;

import codegen.sunTravels.Config.HotelConfig;
import codegen.sunTravels.Entities.HotelBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
public class Core {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HotelConfig.class);
        HotelBean hotel = context.getBean("hotelBean", HotelBean.class);

        System.out.println(hotel);
    }
}

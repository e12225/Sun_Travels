package main.java.codegen.sunTravels.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author - Subhani
 * @Date - 08/11/2017
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("java.codegen.sunTravels.DAO"),
                         @ComponentScan("java.codegen.sunTravels.Services")})
public class SpringConfig {

    @Bean
    public LocalEntityManagerFactoryBean getEntityManagerFactoryBean(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("sun-travels");
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager getJpaTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
        return transactionManager;
    }

//    @Bean
//    public Hotel hotelBean(){
//
//        Hotel hb = new Hotel();
//
//        /**
//         * Instead of hardcoding the values here, these values should be received from the POST request
//         * from the call center agent
//         */
//        hb.setHotelID("ASSL02");
//        hb.setHotelName("Cinnamon Grand Colombo");
//        hb.setHotelAddress("77 Galle Rd, Colombo 00300");
//        hb.setHotelPhoneNumber("011 2 437437");
//
//        return hb;
//    }
}

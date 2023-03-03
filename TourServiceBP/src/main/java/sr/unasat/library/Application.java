package sr.unasat.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sr.unasat.library.controller.HotelController;
import sr.unasat.library.controller.RestaurantController;
import sr.unasat.library.controller.TicketController;
import sr.unasat.library.controller.TouristController;
import sr.unasat.library.service.HotelService;
import sr.unasat.library.service.RestaurantService;
import sr.unasat.library.service.TicketService;
import sr.unasat.library.service.TouristService;
import sr.unasat.library.service.impl.HotelServiceImpl;
import sr.unasat.library.service.impl.RestaurantServiceImpl;
import sr.unasat.library.service.impl.TouristServiceImpl;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {HotelController.class,RestaurantController.class,TouristController.class,TicketController.class,HotelService.class,
RestaurantService.class,TicketService.class,TouristService.class, HotelServiceImpl.class, TouristServiceImpl.class, RestaurantServiceImpl.class,TouristServiceImpl.class,CorsFilter.class})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {


        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
        .singletonMap("server.port","55763"));
        app.run(args);
    }



}

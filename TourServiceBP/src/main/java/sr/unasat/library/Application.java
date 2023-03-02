package sr.unasat.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import sr.unasat.library.controller.HotelController;
import sr.unasat.library.controller.RestaurantController;
import sr.unasat.library.controller.TicketController;
import sr.unasat.library.controller.TouristController;
import sr.unasat.library.service.*;
import sr.unasat.library.service.impl.HotelServiceImpl;
import sr.unasat.library.service.impl.RestaurantServiceImpl;
import sr.unasat.library.service.impl.TouristServiceImpl;

import java.util.Collections;

@ComponentScan(basePackageClasses = {HotelController.class,RestaurantController.class,TouristController.class,TicketController.class,HotelService.class,
RestaurantService.class,TicketService.class,TouristService.class, HotelServiceImpl.class, TouristServiceImpl.class, RestaurantServiceImpl.class,TouristServiceImpl.class})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {


        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
        .singletonMap("server.port","0"));
        app.run(args);
    }


}

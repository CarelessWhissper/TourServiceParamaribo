package sr.unasat.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sr.unasat.library.controller.HotelController;
import sr.unasat.library.controller.RestaurantController;
import sr.unasat.library.controller.TicketController;
import sr.unasat.library.controller.TouristController;



@ComponentScan(basePackageClasses = RestaurantController.class)
@ComponentScan(basePackageClasses = TicketController.class)
@ComponentScan(basePackageClasses = TouristController.class)
@ComponentScan(basePackageClasses = HotelController.class)
@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}

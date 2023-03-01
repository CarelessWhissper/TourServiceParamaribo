package sr.unasat.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sr.unasat.library.controller.HotelController;
import sr.unasat.library.controller.RestaurantController;
import sr.unasat.library.controller.TicketController;
import sr.unasat.library.controller.TouristController;




@ComponentScan(basePackageClasses = {HotelController.class,RestaurantController.class,TouristController.class,TicketController.class})
@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}

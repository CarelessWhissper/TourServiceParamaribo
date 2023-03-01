package sr.unasat.library.service;

import java.util.List;


import org.springframework.stereotype.Service;
import sr.unasat.library.entity.Restaurant;

@Service
public interface RestaurantService {

   Restaurant createRestaurant( Restaurant restaurant);

   Restaurant getRestaurantById(Long restaurantId);

   List<Restaurant> getAllRestaurant();

   Restaurant updateRestaurant(Restaurant restaurant);

   void deleteRestaurant(Long restaurantId);

}

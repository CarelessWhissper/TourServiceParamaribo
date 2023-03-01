package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import  sr.unasat.library.entity.Restaurant;
import sr.unasat.library.repository.RestaurantRepo;
import sr.unasat.library.service.RestaurantService;


@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepo repo;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant){
        return repo.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId){
        Optional<Restaurant> optionalRestaurant = repo.findById(restaurantId);
        return  optionalRestaurant.get();
    }

    @Override
    public List<Restaurant> getAllRestaurant(){
        return repo.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant){
        Restaurant existingRestaurant = repo.findById(restaurant.getId()).get();
        existingRestaurant.setRestaurantName(restaurant.getRestaurantName());
        existingRestaurant.setReservationDetails(restaurant.getReservationDetails());
        existingRestaurant.setNumberOfPeople(restaurant.getNumberOfPeople());
        existingRestaurant.setTourist(restaurant.getTourist());

        Restaurant updatedRestaurant = repo.save(existingRestaurant);
        return  updatedRestaurant;
    }

    @Override
    public void deleteRestaurant(Long restaurantId){
        repo.deleteById(restaurantId);
    }
}

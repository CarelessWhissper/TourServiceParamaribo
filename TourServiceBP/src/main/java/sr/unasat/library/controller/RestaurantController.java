package sr.unasat.library.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sr.unasat.library.service.RestaurantService;
import sr.unasat.library.entity.Restaurant;


@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
     RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        try {
            List<Restaurant> list = restaurantService.get();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurants(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.get(id);

        if (restaurant.isPresent()) {
            return new ResponseEntity<Restaurant>(restaurant.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
        try {
            return new ResponseEntity<Restaurant>(restaurantService.add(restaurant), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/restaurants")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
        try {
            return new ResponseEntity<Restaurant>(restaurantService.add(restaurant), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable Long id) {
        try {
            restaurantService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

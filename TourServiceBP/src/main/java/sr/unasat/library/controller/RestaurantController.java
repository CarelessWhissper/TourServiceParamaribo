package sr.unasat.library.controller;


import java.util.List;


import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sr.unasat.library.service.RestaurantService;
import sr.unasat.library.entity.Restaurant;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private RestaurantService service;

    //build get restaurant REST API

    @PostMapping
    public ResponseEntity<Restaurant>createRestaurant(@RequestBody Restaurant restaurant){
        Restaurant savedRestaurant = service.createRestaurant(restaurant);
        return  new ResponseEntity<>(savedRestaurant,HttpStatus.CREATED);
    }

    //build get restaurant by Id REST API

    @GetMapping("{id}")
    public ResponseEntity<Restaurant>getRestaurantById(@PathVariable("id")Long restaurantId){
        Restaurant restaurant = service.getRestaurantById(restaurantId);

        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }

    //build get all restaurants REST API

    @GetMapping
    public ResponseEntity<List<Restaurant>>getAllRestaurants(){
        List<Restaurant> restaurants= service.getAllRestaurant();

        return new ResponseEntity<>(restaurants,HttpStatus.OK);
    }

    //build update restaurant REST API
    @PutMapping("{id}")
    public ResponseEntity<Restaurant>updateRestaurant(@PathVariable("id")Long restaurantId,
                                                      @RequestBody Restaurant restaurant){
        restaurant.setId(restaurantId);
        Restaurant updatedRestaurant = service.updateRestaurant(restaurant);
        return  new ResponseEntity<>(updatedRestaurant,HttpStatus.OK);
    }


    //build delete Restaurant REST API

    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id")Long restaurantId){
        service.deleteRestaurant(restaurantId);
        return new ResponseEntity<>("Restaurant has been deleted",HttpStatus.OK);
    }


}

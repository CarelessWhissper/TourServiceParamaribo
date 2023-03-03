package sr.unasat.library.controller;


import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import sr.unasat.library.entity.Tourist;


import sr.unasat.library.service.TouristService;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/tourists")
public class TouristController {


    private TouristService touristService;


    // build create tourist REST API

    @PostMapping()
    public ResponseEntity<Tourist> createTourist(@RequestBody Tourist tourist) {
        Tourist savedTourist = touristService.createTourist(tourist);
        return new ResponseEntity<>(savedTourist, HttpStatus.CREATED);
    }




    //build get tourist by id REST API

    @GetMapping("{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable("id") Long touristId) {
        Tourist tourist = touristService.getTouristById(touristId);


        return new ResponseEntity<>(tourist, HttpStatus.OK);
    }

    //build get all tourist REST API

    @GetMapping
    public ResponseEntity<List<Tourist>> getAllTourists() {
        List<Tourist> tourists = touristService.getAllTourists();
        return new ResponseEntity<>(tourists, HttpStatus.OK);
    }

    //build update tourist REST API
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tourist> updateTourist(@PathVariable("id") Long touristId, @RequestBody Tourist tourist) {
        tourist.setId(touristId);
        Tourist updatedTourist = touristService.updateTourist(tourist);
        return new ResponseEntity<>(updatedTourist, HttpStatus.OK);
    }

    //build delete tourist REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Long touristId) {
        try {
            touristService.deleteTourist(touristId);
            return new ResponseEntity<>("Tourist has been deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete tourist: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
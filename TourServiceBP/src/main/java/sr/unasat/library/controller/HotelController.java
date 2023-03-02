package sr.unasat.library.controller;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;

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


import sr.unasat.library.entity.Hotel;
import sr.unasat.library.service.HotelService;


@RestController
@RequestMapping("/api/hotel")
public class  HotelController {


    @Autowired
    private HotelService service;

    public HotelController(HotelService hotelService){
        this.service = hotelService;
    }

    //build create Hotel REST API

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = service.createHotel(hotel);
        return  new ResponseEntity<>(savedHotel,HttpStatus.CREATED);
    }

    //build get Hotel by id REST API

    // http://localhost:8081/api/hotel/1

    @GetMapping("{id}")
    public ResponseEntity<Hotel>getHotelById(@PathVariable("id")Long hotelId){
        Hotel hotel = service.getHotelById(hotelId);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }

    // build get all users REST API
    // http://localhost:8080/api/hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = service.getAllHotels();
        return new ResponseEntity<>(hotels,HttpStatus.OK);
    }

    //build update Hotel REST API

    @PutMapping
    // http://localhost:8081/api/hotel/1

    public ResponseEntity<Hotel> updateHotel(@PathVariable("id")Long hotelId,
                                             @RequestBody Hotel hotel){
        hotel.setId(hotelId);
        Hotel updatedHotel = service.updateHotel(hotel);
        return new ResponseEntity<>(updatedHotel,HttpStatus.OK);
    }

    //build delete Hotel REST API


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") Long hotelId){
        service.deleteHotel(hotelId);
        return new ResponseEntity<>("Hotel has been deleted", HttpStatus.OK);
    }


}

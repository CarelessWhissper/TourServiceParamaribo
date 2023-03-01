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

import sr.unasat.library.entity.Hotel;
import sr.unasat.library.service.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        try {
            List<Hotel> list = hotelService.get();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelService.get(id);

        if (hotel.isPresent()) {
            return new ResponseEntity<Hotel>(hotel.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/hotels")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        try {
            return new ResponseEntity<Hotel>(hotelService.add(hotel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Hotel>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/hotels")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        try {
            return new ResponseEntity<Hotel>(hotelService.add(hotel), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Hotel>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<HttpStatus> deleteHotel(@PathVariable Long id) {
        try {
            hotelService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

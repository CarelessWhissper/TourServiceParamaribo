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


import sr.unasat.library.entity.Tourist;

import sr.unasat.library.service.TouristService;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    TouristService touristService;

    @GetMapping("/tourist")
    public ResponseEntity<List<Tourist>> getAllTourists() {
        try {
            List<Tourist> list = touristService.get();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tourist/{id}")
    public ResponseEntity<Tourist> getTourist(@PathVariable Long id) {
        Optional<Tourist> tourist = touristService.get(id);

        if (tourist.isPresent()) {
            return new ResponseEntity<Tourist>(tourist.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Tourist>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tourist")
    public ResponseEntity<Tourist> saveTourist(@RequestBody Tourist tourist) {
        try {
            return new ResponseEntity<Tourist>(touristService.add(tourist), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Tourist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/tourists")
    public ResponseEntity<Tourist> updateTourist(@RequestBody Tourist tourist) {
        try {
            return new ResponseEntity<Tourist>(touristService.add(tourist), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Tourist>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tourist/{id}")
    public ResponseEntity<HttpStatus> deleteTourist(@PathVariable Long id) {
        try {
            touristService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

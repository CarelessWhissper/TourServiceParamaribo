package sr.unasat.library.controller;


import java.util.List;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import sr.unasat.library.entity.Tourist;


import sr.unasat.library.service.TouristService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tourists")
public class TouristController {



    private TouristService touristService;


    // build create tourist REST API

    @PostMapping
     public ResponseEntity<Tourist> createTourist(@RequestBody Tourist tourist){
        Tourist savedTourist = touristService.createTourist(tourist);
        return  new ResponseEntity<>(savedTourist,HttpStatus.OK);
    }


    //build get tourist by id REST API

   @GetMapping("{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable("id")Long touristId){
        Tourist tourist = touristService.getTouristById(touristId);
        return  new ResponseEntity<>(tourist,HttpStatus.OK);
   }

   //build get all tourist REST API

   @GetMapping
   public ResponseEntity<List<Tourist>>getAllTourists(){
        List<Tourist> tourists = touristService.getAllTourists();
        return new ResponseEntity<>(tourists,HttpStatus.OK);
   }

   //build update tourist REST API
    @PutMapping ("{id}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable("id")Long touristId,
                                                 @RequestBody Tourist tourist){
        tourist.setId(touristId);
        Tourist updatedTourist = touristService.updateTourist(tourist);
        return  new ResponseEntity<>(updatedTourist,HttpStatus.OK);
    }

    //build delete tourist REST API

    @DeleteMapping
    public ResponseEntity<String> deleteTourist(@PathVariable("id")Long touristId){
        touristService.deleteTourist(touristId);
        return new ResponseEntity<>("Tourists has been deleted",HttpStatus.OK);
    }

}


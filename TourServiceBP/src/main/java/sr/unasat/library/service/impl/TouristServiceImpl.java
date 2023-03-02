package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import sr.unasat.library.entity.Tourist;

import sr.unasat.library.repository.TouristRepo;
import sr.unasat.library.service.TouristService;

@Service
@AllArgsConstructor
public  class TouristServiceImpl implements TouristService {

    private final TouristRepo touristRepo;


    @Override
    public Tourist createTourist (Tourist tourist){
        return touristRepo.save(tourist);
    }

    @Override
    public List<Tourist> getAllTourists(){
        return touristRepo.findAll();
    }

    @Override
    public Tourist getTouristById(Long touristId){
        Optional<Tourist> optionalTourist = touristRepo.findById(touristId);
        return optionalTourist.get();
    }

    @Override
    public Tourist updateTourist(Tourist tourist){
        Tourist existingTourist = touristRepo.findById(tourist.getId()).get();
        existingTourist.setFullName(tourist.getFullName());
        existingTourist.setDateOfBirth(tourist.getDateOfBirth());
        existingTourist.setLocationOfOrigin(tourist.getLocationOfOrigin());

        Tourist updatedTourist = touristRepo.save(existingTourist);
        return  updatedTourist;
    }

    @Override
    public void deleteTourist(Long touristId){
        touristRepo.deleteById(touristId);
    }
}

package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.unasat.library.entity.Tourist;

import sr.unasat.library.repository.TouristRepo;
import sr.unasat.library.service.TouristService;

@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    TouristRepo touristRepo;

    @Override
    public Tourist add(Tourist tourist) {
        return touristRepo.save(tourist);
    }

    @Override
    public List get() {
        return touristRepo.findAll();
    }

    @Override
    public Optional get(Long id) {
        return touristRepo.findById(id);
    }


    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            touristRepo.delete((Tourist) get(id).get());
        }
    }
}

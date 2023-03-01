package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  sr.unasat.library.entity.Restaurant;
import sr.unasat.library.repository.RestaurantRepo;
import sr.unasat.library.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public Restaurant add(Restaurant restaurant){
        return  restaurantRepo.save(restaurant);
    }

    @Override
    public List get(){
        return restaurantRepo.findAll();
    }


    @Override
    public Optional get(Long id){
        return  restaurantRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            restaurantRepo.delete((Restaurant) get(id).get());
        }
    }
}

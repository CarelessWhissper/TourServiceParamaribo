package sr.unasat.library.service;

import java.util.List;
import java.util.Optional;

import sr.unasat.library.entity.Restaurant;
public interface RestaurantService {

    Restaurant add(Restaurant restaurant);

    List get();

    Optional get(Long id);

    void delete(Long id);
}

package sr.unasat.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sr.unasat.library.entity.Restaurant;

import java.util.List;
import java.util.Optional;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
    Restaurant add(Restaurant restaurant);

    List get();

    Optional get(Long id);

    void delete(Long id);
}

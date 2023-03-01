package sr.unasat.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import sr.unasat.library.entity.Restaurant;

import java.util.List;
import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
    Restaurant add(Restaurant restaurant);

    List get();

    Optional get(Long id);

    void delete(Long id);
}

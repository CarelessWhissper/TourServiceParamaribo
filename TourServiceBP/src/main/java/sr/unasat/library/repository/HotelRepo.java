package sr.unasat.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import sr.unasat.library.entity.Hotel;

@Repository
@EnableJpaRepositories
public interface HotelRepo extends  JpaRepository<Hotel,Long> {
}

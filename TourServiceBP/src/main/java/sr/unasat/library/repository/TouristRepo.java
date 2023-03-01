package sr.unasat.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  sr.unasat.library.entity.Tourist;

@Repository
public interface TouristRepo extends JpaRepository <Tourist,Long> {

}

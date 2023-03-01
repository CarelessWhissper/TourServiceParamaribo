package sr.unasat.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import  sr.unasat.library.entity.Tourist;

import java.util.List;

@Repository
public interface TouristRepo extends JpaRepository <Tourist,Long> {


}

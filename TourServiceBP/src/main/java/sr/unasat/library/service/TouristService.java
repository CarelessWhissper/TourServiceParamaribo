package sr.unasat.library.service;

import java.util.List;
import java.util.Optional;

import  sr.unasat.library.entity.Tourist;

public interface TouristService {

    Tourist add (Tourist tourist);

    List get();

    Optional get (Long id);

     void delete(Long id);
}

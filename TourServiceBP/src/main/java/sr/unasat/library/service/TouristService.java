package sr.unasat.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import  sr.unasat.library.entity.Tourist;

@Service
public interface TouristService {

    Tourist createTourist( Tourist tourist);

    Tourist getTouristById(Long touristId);

    List<Tourist>getAllTourists();

    Tourist updateTourist(Tourist tourist);

    void deleteTourist (Long touristId);
}

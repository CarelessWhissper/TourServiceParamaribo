package sr.unasat.library.service;

import java.util.List;
import java.util.Optional;
import sr.unasat.library.entity.Hotel;

public interface HotelService {

    Hotel add(Hotel hotel);

    List get();

    Optional get(Long id);

    void delete(Long id);
}

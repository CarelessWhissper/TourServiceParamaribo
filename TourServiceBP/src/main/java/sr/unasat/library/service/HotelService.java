package sr.unasat.library.service;

import java.util.List;


import org.springframework.stereotype.Service;
import sr.unasat.library.entity.Hotel;

@Service
public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(Long HotelId);

    List<Hotel>getAllHotels();

    Hotel updateHotel(Hotel hotel);

    void deleteHotel(Long HotelId);



}

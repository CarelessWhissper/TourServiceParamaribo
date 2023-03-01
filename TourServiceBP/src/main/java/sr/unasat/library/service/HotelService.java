package sr.unasat.library.service;

import java.util.List;

import sr.unasat.library.entity.Hotel;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(Long HotelId);

    List<Hotel>getAllHotels();

    Hotel updateHotel(Hotel hotel);

    void deleteHotel(Long HotelId);

}

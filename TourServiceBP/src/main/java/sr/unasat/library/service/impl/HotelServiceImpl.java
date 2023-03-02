package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import sr.unasat.library.entity.Hotel;
import sr.unasat.library.repository.HotelRepo;
import sr.unasat.library.service.HotelService;


@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {



    private HotelRepo repo;



    @Override
    public Hotel createHotel(Hotel hotel){
        return repo.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long HotelId){
        Optional<Hotel> optionalHotel = repo.findById(HotelId);
        return  optionalHotel.get();
    }
    @Override
    public List<Hotel>getAllHotels(){
        return repo.findAll();
    }
    @Override
    public Hotel updateHotel(Hotel hotel){
        Hotel existingHotel = repo.findById(hotel.getId()).get();
        existingHotel.setHotelName(hotel.getHotelName());
        existingHotel.setTourist(hotel.getTourist());
        existingHotel.setNumberOfRooms(hotel.getNumberOfRooms());
        existingHotel.setReservationDetails(hotel.getReservationDetails());
        existingHotel.setNumberOfStayingDays(hotel.getNumberOfStayingDays());

        Hotel updatedHotel = repo.save(existingHotel);
        return  updatedHotel;
    }

    @Override
    public void deleteHotel(Long HotelId){
        repo.deleteById(HotelId);
    }

}

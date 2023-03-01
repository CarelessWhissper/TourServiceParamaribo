package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.unasat.library.entity.Hotel;
import sr.unasat.library.repository.HotelRepo;
import sr.unasat.library.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

  @Override
  public Hotel add(Hotel hotel){
      return hotelRepo.save(hotel);
  }

  @Override
  public List get(){
      return hotelRepo.findAll();
  }

  @Override
  public Optional get(Long id){
      return hotelRepo.findById(id);
  }

  @Override
  public void delete(Long id){
      if (get(id).isPresent()) {
          hotelRepo.delete((Hotel) get(id).get());
      }
  }
}

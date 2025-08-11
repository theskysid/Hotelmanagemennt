package com.theskysid.hotelmanagement.Service;

import com.theskysid.hotelmanagement.Communicator.RestTemplateCommunicator;
import com.theskysid.hotelmanagement.DTO.HotelDTO;
import com.theskysid.hotelmanagement.DTO.UpdateHotelAddressDTO;
import com.theskysid.hotelmanagement.Entity.Hotel;
import com.theskysid.hotelmanagement.Exceptions.DuplicateHotelException;
import com.theskysid.hotelmanagement.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

   @Autowired
   HotelRepository hotelRepository;

   @Autowired
   RestTemplateCommunicator  restTemplateCommunicator;

   public ResponseEntity<Hotel> saveHotel(HotelDTO hotelDTO){
      Hotel hotel = new Hotel();

      //through this we are checking if the same name hotel is present in the database or not
      if (hotelRepository.findByName(hotelDTO.getName()).isPresent() ) {
         throw  new DuplicateHotelException("Hotel already exists");
      }

      hotel.setName(hotelDTO.getName());
      hotel.setCity(hotelDTO.getCity());
      hotel.setPostalCode(hotelDTO.getPostalCode());
      hotel.setRating(hotelDTO.getPostalCode());
      hotel.setAvailable(hotelDTO.isAvailable());
      hotel.setRating(hotelDTO.getRating());
      hotel.setAddress(hotelDTO.getAddress());



      hotelRepository.save(hotel);
      return new ResponseEntity<>(hotel, HttpStatus.CREATED);
   }

   public List<Hotel> getAllHotels(){
      return hotelRepository.findAll();
   }

   public ResponseEntity<Hotel> getHotelById(Long id){
      Optional<Hotel> hotelBox = hotelRepository.findById(id);
      //find by id returns the optional value thats why we formed a box to check if the value is present in the database

      Float hotelActualRating = restTemplateCommunicator.getActualHotelRating(id);
      Hotel hotel = hotelBox.get();
      hotel.setRating(hotelActualRating);

      if(hotelBox.isPresent()){
         return new ResponseEntity<>(hotel, HttpStatus.OK);
      } else
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

   }

   public Hotel updateHotel(HotelDTO hotelDTO, Long id){
       Hotel hotel = getHotelById(id).getBody();
       if(hotel != null){
          hotel.setName(hotelDTO.getName());
          hotel.setCity(hotelDTO.getCity());
          hotel.setPostalCode(hotelDTO.getPostalCode());
          hotel.setRating(hotelDTO.getPostalCode());
          hotel.setAvailable(hotelDTO.isAvailable());
          hotel.setRating(hotelDTO.getRating());
          hotel.setAddress(hotelDTO.getAddress());

          hotelRepository.save(hotel);
            return new ResponseEntity<>(hotel, HttpStatus.ACCEPTED).getBody(); //getBody gives the actual object
       } else
          return null;
   }

   public void deleteHotel(Long id){
      Hotel hotel = getHotelById(id).getBody();
      if(hotel != null){
         hotelRepository.deleteById(id);
      }
   }

   public Hotel updateHotelAddress(UpdateHotelAddressDTO updateHotelAddressDTO, Long id){
      Hotel hotel = getHotelById(id).getBody();
      if(hotel != null){
         hotel.setCity(updateHotelAddressDTO.getCity());
         hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());
         hotel.setAddress(updateHotelAddressDTO.getAddress());

         return hotelRepository.save(hotel);
      } else
         return null;
   }

}


package com.theskysid.hotelmanagement.Controller;

import com.theskysid.hotelmanagement.DTO.HotelDTO;
import com.theskysid.hotelmanagement.DTO.UpdateHotelAddressDTO;
import com.theskysid.hotelmanagement.Entity.Hotel;
import com.theskysid.hotelmanagement.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

   @Autowired
   HotelService hotelService;

   @PostMapping("/createhotel")
   public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO){
      return hotelService.saveHotel(hotelDTO);
   }

   @GetMapping("/getallhotels")
   public List<Hotel> getAllHotels(){
      return hotelService.getAllHotels();
   }

   @GetMapping("/gethotel/{id}")
   public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
      return hotelService.getHotelById(id);
   }

   @PutMapping("/updatehotel/{id}")
   public Hotel updateHotel(@RequestBody HotelDTO hotelDTO, @PathVariable Long id){
      return hotelService.updateHotel(hotelDTO,id);
   }

   @PutMapping("/updatehoteladdress/{id}")
   public Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable Long id){
      return hotelService.updateHotelAddress(updateHotelAddressDTO, id);
   }

   @DeleteMapping("/deletehotel/{id}")
   public void deleteHotel(@PathVariable Long id){
      hotelService.deleteHotel(id);
   }
}

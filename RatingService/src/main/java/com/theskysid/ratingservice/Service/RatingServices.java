package com.theskysid.ratingservice.Service;

import com.theskysid.ratingservice.Entity.Rating;
import com.theskysid.ratingservice.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RatingServices {


   @Autowired
   private RatingRepository ratingRepository;


   public Rating addRating(Rating rating) {
      return ratingRepository.save(rating);
   }

   public Rating getRatingByHotelId(Long hotelid) {
      return ratingRepository.findByHotelId(hotelid);
   }
}

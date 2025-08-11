package com.theskysid.ratingservice.Contoller;

import com.theskysid.ratingservice.Entity.Rating;
import com.theskysid.ratingservice.Service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

   @Autowired
   private RatingServices ratingServices;

   @PostMapping("/addrating")
   public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
      Rating ratingNew = ratingServices.addRating(rating);

      return new ResponseEntity<>(ratingNew, HttpStatus.CREATED);
   }


   @GetMapping("/getratingbyhotelid/{hotelid}")
   public ResponseEntity<Float> getRatingByHotelId(@PathVariable Long hotelid){
      Rating rating = ratingServices.getRatingByHotelId(hotelid);
      return new ResponseEntity<>(rating.getHotelActualRating(), HttpStatus.OK);
   }
}

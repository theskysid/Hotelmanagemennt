package com.theskysid.ratingservice.Repository;

import com.theskysid.ratingservice.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

   public Rating findByHotelId(Long hotelid);

}

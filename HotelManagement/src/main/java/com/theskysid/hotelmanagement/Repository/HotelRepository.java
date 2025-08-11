package com.theskysid.hotelmanagement.Repository;

import com.theskysid.hotelmanagement.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

   Optional<Hotel> findByName(String name);
}

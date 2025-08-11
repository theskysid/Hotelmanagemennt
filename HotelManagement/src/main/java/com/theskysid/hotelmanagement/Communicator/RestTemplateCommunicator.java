package com.theskysid.hotelmanagement.Communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunicator {

   private final RestTemplate restTemplate;

   @Autowired
   public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder) {
      this.restTemplate = restTemplateBuilder.build();
   }

   public Float getActualHotelRating(long hotelid){
      String url = "http://localhost:8084/rating/getratingbyhotelid/"+hotelid;

      ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url, Float.class);
      return hotelRating.getBody();
   }
}

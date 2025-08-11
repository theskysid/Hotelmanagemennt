package com.theskysid.hotelmanagement.Entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
   LocalDateTime timestamp;
   String errorMessage;
   String errorDetails;
   String errorCode;


   public ErrorResponse(String errorDetails, String errorCode, String errorMessage) {
      this.timestamp = LocalDateTime.now();
      this.errorDetails = errorDetails;
      this.errorCode = errorCode;
      this.errorMessage = errorMessage;
   }
}

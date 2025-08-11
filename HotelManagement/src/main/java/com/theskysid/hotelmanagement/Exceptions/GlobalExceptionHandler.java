package com.theskysid.hotelmanagement.Exceptions;

import com.theskysid.hotelmanagement.Entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(DuplicateHotelException.class)
   public ResponseEntity<ErrorResponse> duplicateHotelExceptionHandler(DuplicateHotelException dhex, WebRequest webRequest){
      ErrorResponse errorResponse = new ErrorResponse(dhex.getMessage(),webRequest.getDescription(false), "Duplicate Hotel");

      return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
   }
}

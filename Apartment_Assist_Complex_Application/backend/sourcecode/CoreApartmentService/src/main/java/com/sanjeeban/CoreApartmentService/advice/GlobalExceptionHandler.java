package com.sanjeeban.CoreApartmentService.advice;


import com.sanjeeban.CoreApartmentService.customException.InvalidCredentialsException;
import com.sanjeeban.CoreApartmentService.dto.GenericApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<GenericApiResponse<Object>> handleException(InvalidCredentialsException ex) {

        return ResponseEntity
                .status(400)
                .body(GenericApiResponse.failure(ex.getMessage()));
    }
}

package org.example.testtaskgp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Void> handleHotelNotFound(HotelNotFoundException exception) {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            UnknownBrandNameException.class,
            UnknownAmenitiesException.class,
            UnknownHistogramParameterException.class
    })
    public ResponseEntity<Void> handleBadRequest() {

        return ResponseEntity.badRequest().build();
    }
}

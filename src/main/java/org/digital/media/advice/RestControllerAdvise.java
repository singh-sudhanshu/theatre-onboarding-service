package org.digital.media.advice;

import lombok.extern.slf4j.Slf4j;
import org.digital.media.exception.TheatreNotFoundException;
import org.digital.media.model.entity.Theatre;
import org.digital.media.model.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestControllerAdvise {

    @ExceptionHandler(TheatreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Theatre> productNotFoundException(TheatreNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserResponse userIllegalArgumentException(IllegalArgumentException ex) {
        return new UserResponse(null, 400, ex.getMessage());
    }
}

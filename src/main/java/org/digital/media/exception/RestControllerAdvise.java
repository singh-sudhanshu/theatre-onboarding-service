package org.digital.media.exception;

import lombok.extern.slf4j.Slf4j;
import org.digital.media.model.Theatre;
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
}

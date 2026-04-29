package br.erudio.exception.hadler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice

public class CustomEntityExceptionHandler  {

@ExceptionHandler(IllegalArgumentException.class)

    public final ResponseEntity<ResponseException> handAllException
            (Exception ex, WebRequest request){
        ResponseException response = new ResponseException
                (new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ResourceNotFoundException.class)

    public final ResponseEntity<ResponseException> handleNotFoundException
            (Exception  ex, WebRequest request) {

        ResponseException response = new ResponseException

            (new Date(), ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);

    }



}

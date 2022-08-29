/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credifamilia.crudClientes.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cenef
 */
@ControllerAdvice
public class ApiExceptionHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleApiRequestException(MethodArgumentNotValidException ex) {
        //Payload information 

        LOGGER.error("El parametro "+ ex.getBindingResult().getFieldError().getField() + " " + ex.getBindingResult().getFieldError().getDefaultMessage());
        
        return new ResponseEntity<>(new ApiException(
                "El parametro "+ ex.getBindingResult().getFieldError().getField() + " " + ex.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        
        /*if (e instanceof HttpRequestMethodNotSupportedException) {
            ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
        }*/
    }

}

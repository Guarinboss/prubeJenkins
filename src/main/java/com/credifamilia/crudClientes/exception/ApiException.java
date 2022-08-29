/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credifamilia.crudClientes.exception;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author cenef
 */
public class ApiException {
    private final String message; 


    public ApiException(String message) {
        this.message = message;
    }
    
    

    public String getMessage() {
        return message;
    }


    
    
}

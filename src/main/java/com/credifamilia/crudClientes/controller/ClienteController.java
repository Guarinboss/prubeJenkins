/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credifamilia.crudClientes.controller;

import com.credifamilia.crudClientes.entity.Clientes;
import com.credifamilia.crudClientes.service.ClienteService;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cenef
 */

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    

    
    @Autowired
    private ClienteService clienteservice; 
    
    @GetMapping("/obtener")
    public List<Clientes> listar(){
        return clienteservice.listar();
    }
    
    @PostMapping("/crear")
    public ResponseEntity crear(@RequestBody @Valid Clientes cliente){
        Period edad = Period.between(cliente.getFechaDeNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        if(edad.getYears() >= 18 && edad.getYears() <= 65){
            cliente.setViable(Boolean.TRUE);
        };
        return new ResponseEntity<>(clienteservice.crear(cliente), HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizar(@RequestBody @Valid  Clientes cliente){
        return new ResponseEntity<>(clienteservice.actualizar(cliente), HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(clienteservice.eliminar(id), HttpStatus.NO_CONTENT);
        
    }
    
   
}

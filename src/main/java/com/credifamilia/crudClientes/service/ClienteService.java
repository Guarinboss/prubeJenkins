/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credifamilia.crudClientes.service;

import com.credifamilia.crudClientes.entity.Clientes;
import com.credifamilia.crudClientes.exception.ApiRequestException;
import com.credifamilia.crudClientes.repo.ClienteRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cenef
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienterepo;

    public Clientes crear(Clientes cliente) {
        //throw new ApiRequestException("Parametros incorrectos en la peticion");
        return clienterepo.save(cliente);
    }

    public Clientes actualizar(Clientes cliente) {
        return clienterepo.save(cliente);
    }

    public List<Clientes> listar() {
        return clienterepo.findAll();
    }

    public boolean eliminar(Integer id) {
        clienterepo.deleteById(id);
        return true;
    }

}

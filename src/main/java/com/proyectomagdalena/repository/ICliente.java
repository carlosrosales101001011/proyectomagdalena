package com.proyectomagdalena.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyectomagdalena.models.Clientes;

public interface ICliente extends CrudRepository<Clientes, Long> {

}

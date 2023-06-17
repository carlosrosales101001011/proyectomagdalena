package com.proyectomagdalena.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyectomagdalena.models.Productos;

public interface IProducto extends CrudRepository<Productos, Long> {

}

package com.proyectomagdalena.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectomagdalena.repository.ICliente;

import lombok.extern.slf4j.Slf4j;
import com.proyectomagdalena.models.Clientes;
@Controller
@Slf4j
public class ClienteController {

    
    @Autowired
    private ICliente clienteservice;

    @GetMapping("/Cliente")
    public String Clientes(Model model) {
        var clientes = clienteservice.findAll();
        model.addAttribute("clientes",clientes);
        return "Clientes";
    }
    
    
     @GetMapping("Cliente/agregar")
    public String agregar(Clientes clientes) {

        return "ModificarCli";
    }
    
    
     @PostMapping("Cliente/guardar")
    public  String guardar(Clientes alumnos){
      clienteservice.save(alumnos);
      return "redirect:/Cliente";
      
    }
    
    @GetMapping("Cliente/editar/{id}")
    public String editar(Clientes clientes, Model model) {
        clientes = clienteservice.findById(clientes.getId()).orElse(null);
        model.addAttribute("clientes",clientes);
        return "ModificarCli";
    }
    
    
     @GetMapping("Cliente/Eliminar/{id}")
    public String Eliminar(Clientes clientes) {
       clienteservice.delete(clientes);
        return "redirect:/Cliente";
    }
}

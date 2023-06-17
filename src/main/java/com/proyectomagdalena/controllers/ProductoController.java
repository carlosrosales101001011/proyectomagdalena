package com.proyectomagdalena.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectomagdalena.repository.IProducto;
import com.proyectomagdalena.models.Productos;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private IProducto productoService;

    @GetMapping("/Producto")
    public String Productos(Model model) {
        var productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "Productos";
    }
    
     @GetMapping("/ProductoCompra")
    public String ProductosComp(Model model) {
        var productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "ProductosComp";
    }

    @GetMapping("Producto/agregar")
    public String agregar(Productos productos) {

        return "ModificarPro";
    }

    @PostMapping("Producto/guardar")
    public String guardar(@Valid Productos productos, Errors errores, Model model, @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute) {
        if (errores.hasErrors()) {
            return "ModificarPro";
        }

        if (!imagen.isEmpty()) {
            //Path directorioImagenes=Paths.get("src//main//resources//static");
            String rutaAbsoluta = "src//main//resources//static/imagenes";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                productos.setImagen(imagen.getOriginalFilename());

            } catch (IOException ex) {
                ex.printStackTrace();

            }
          
        }
    productoService.save(productos);
        return "redirect:/Producto";

    }

    @GetMapping("Producto/editar/{idproducto}")
    public String editar(Productos productos, Model model) {
        productos = productoService.findById(productos.getIdproducto()).orElse(null);
        model.addAttribute("productos", productos);
        return "ModificarPro";
    }

    @GetMapping("Producto/detalle/{idproducto}")
    public String detalle(Productos productos, Model model, RedirectAttributes attribute) {

        if (productos.getIdproducto() > 0) {
            productos = productoService.findById(productos.getIdproducto()).orElse(null);

            if (productos == null) {
                attribute.addFlashAttribute("error ", "ATENCION :EL ID del producto no existe!");
                return "redirect:/Producto";

            }
        } else {
            attribute.addFlashAttribute("error", "Tencion :Error con el ID del producto");
            return "DetalleProducto";

        }
       
        model.addAttribute("titulo","Detalle del Producto : " + productos.getNombre());
        model.addAttribute("productos", productos);

        return "DetalleProducto";
    }

    
     @GetMapping("Producto/compra/{idproducto}")
    public String compra(Productos productos, Model model, RedirectAttributes attribute) {
     
        if (productos.getIdproducto() > 0) {
            productos = productoService.findById(productos.getIdproducto()).orElse(null);

            if (productos == null) {
                attribute.addFlashAttribute("error ", "ATENCION :EL ID del producto no existe!");
                return "redirect:/Producto";

            }
        } else {
            attribute.addFlashAttribute("error", "Tencion :Error con el ID del producto");
            return "DetalleProducto";

        }
         
          
        model.addAttribute("titulo","Detalle del Producto : " + productos.getNombre());
        model.addAttribute("productos", productos);

        return "CompraProducto";
    }
    
    @GetMapping("Producto/Eliminar/{idproducto}")
    public String Eliminar(Productos productos) {
        productoService.delete(productos);
        return "redirect:/Producto";
    }
    
}

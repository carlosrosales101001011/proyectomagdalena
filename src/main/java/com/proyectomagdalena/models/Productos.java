package com.proyectomagdalena.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Productos  implements Serializable{
        private static  final long serialVersionUID = 11;
    
   @Id
   @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long  idproducto;
    public Long getIdproducto() {
	return idproducto;
}
public void setIdproducto(Long idproducto) {
	this.idproducto = idproducto;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getImagen() {
	return imagen;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	private String nombre;
    private String imagen;
    private double precio;
    private int stock ;
    private String marca ;
  
    
}

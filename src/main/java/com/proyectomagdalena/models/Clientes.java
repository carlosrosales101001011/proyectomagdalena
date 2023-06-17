
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
@Table(name="cliente")
public class Clientes implements Serializable {
    private static  final long serialVersionUID = 11;
    
   @Id
   @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long  id;
   
   
		private String  razon_social;
		
		
		private String dni;
		
		
		private String telefono;
		
		private String email ;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getRazon_social() {
			return razon_social;
		}

		public void setRazon_social(String razon_social) {
			this.razon_social = razon_social;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
    
}

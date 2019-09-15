package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datos_de_facturacion database table.
 * 
 */
@Entity
@Table(name="datos_de_facturacion")
@NamedQuery(name="DatosDeFacturacion.findAll", query="SELECT d FROM DatosDeFacturacion d")
public class DatosDeFacturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String apellido;

	private String direccion;

	private String email;

	private String nombre;

	private String pais;

	private String provincia;

	public DatosDeFacturacion() {
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
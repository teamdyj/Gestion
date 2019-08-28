package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Datos_de_facturacion database table.
 * 
 */
@Entity
@NamedQuery(name="Datos_de_facturacion.findAll", query="SELECT d FROM Datos_de_facturacion d")
public class Datos_de_facturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String apellido;

	private String direccion;

	private String email;

	private String nombre;

	private String pais;

	private String provincia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarios_email")
	private Usuario usuario;

	public Datos_de_facturacion() {
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
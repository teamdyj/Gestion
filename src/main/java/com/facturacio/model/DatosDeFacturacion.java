package com.facturacio.model;

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

	@EmbeddedId
	private DatosDeFacturacionPK id;

	private String apellido;

	private String direccion;

	private String email;

	private String nombre;

	private String pais;

	private String provincia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="usuarios_email", referencedColumnName="email"),
		@JoinColumn(name="usuarios_Rol_idRol", referencedColumnName="Rol_idRol")
		})
	private Usuario usuario;

	public DatosDeFacturacion() {
	}

	public DatosDeFacturacionPK getId() {
		return this.id;
	}

	public void setId(DatosDeFacturacionPK id) {
		this.id = id;
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
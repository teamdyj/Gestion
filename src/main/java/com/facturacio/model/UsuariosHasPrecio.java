package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_has_precios database table.
 * 
 */
@Entity
@Table(name="usuarios_has_precios")
@NamedQuery(name="UsuariosHasPrecio.findAll", query="SELECT u FROM UsuariosHasPrecio u")
public class UsuariosHasPrecio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosHasPrecioPK id;

	public UsuariosHasPrecio() {
	}

	public UsuariosHasPrecioPK getId() {
		return this.id;
	}

	public void setId(UsuariosHasPrecioPK id) {
		this.id = id;
	}

}
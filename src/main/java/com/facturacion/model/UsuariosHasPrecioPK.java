package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios_has_precios database table.
 * 
 */
@Embeddable
public class UsuariosHasPrecioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	@Column(insertable=false, updatable=false)
	private int usuarios_Rol_idRol;

	@Column(insertable=false, updatable=false)
	private int precios_idPrecios;

	public UsuariosHasPrecioPK() {
	}
	public String getUsuariosEmail() {
		return this.usuariosEmail;
	}
	public void setUsuariosEmail(String usuariosEmail) {
		this.usuariosEmail = usuariosEmail;
	}
	public int getUsuarios_Rol_idRol() {
		return this.usuarios_Rol_idRol;
	}
	public void setUsuarios_Rol_idRol(int usuarios_Rol_idRol) {
		this.usuarios_Rol_idRol = usuarios_Rol_idRol;
	}
	public int getPrecios_idPrecios() {
		return this.precios_idPrecios;
	}
	public void setPrecios_idPrecios(int precios_idPrecios) {
		this.precios_idPrecios = precios_idPrecios;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosHasPrecioPK)) {
			return false;
		}
		UsuariosHasPrecioPK castOther = (UsuariosHasPrecioPK)other;
		return 
			this.usuariosEmail.equals(castOther.usuariosEmail)
			&& (this.usuarios_Rol_idRol == castOther.usuarios_Rol_idRol)
			&& (this.precios_idPrecios == castOther.precios_idPrecios);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuariosEmail.hashCode();
		hash = hash * prime + this.usuarios_Rol_idRol;
		hash = hash * prime + this.precios_idPrecios;
		
		return hash;
	}
}
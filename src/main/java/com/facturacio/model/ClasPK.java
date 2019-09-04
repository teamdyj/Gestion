package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the clases database table.
 * 
 */
@Embeddable
public class ClasPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idClases;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	@Column(insertable=false, updatable=false)
	private int usuarios_Rol_idRol;

	public ClasPK() {
	}
	public int getIdClases() {
		return this.idClases;
	}
	public void setIdClases(int idClases) {
		this.idClases = idClases;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClasPK)) {
			return false;
		}
		ClasPK castOther = (ClasPK)other;
		return 
			(this.idClases == castOther.idClases)
			&& this.usuariosEmail.equals(castOther.usuariosEmail)
			&& (this.usuarios_Rol_idRol == castOther.usuarios_Rol_idRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idClases;
		hash = hash * prime + this.usuariosEmail.hashCode();
		hash = hash * prime + this.usuarios_Rol_idRol;
		
		return hash;
	}
}
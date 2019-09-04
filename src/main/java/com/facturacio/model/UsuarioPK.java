package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String email;

	@Column(insertable=false, updatable=false)
	private int rol_idRol;

	public UsuarioPK() {
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRol_idRol() {
		return this.rol_idRol;
	}
	public void setRol_idRol(int rol_idRol) {
		this.rol_idRol = rol_idRol;
	}

	
	public UsuarioPK(String email, int rol_idRol) {
		super();
		this.email = email;
		this.rol_idRol = rol_idRol;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			this.email.equals(castOther.email)
			&& (this.rol_idRol == castOther.rol_idRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.email.hashCode();
		hash = hash * prime + this.rol_idRol;
		
		return hash;
	}
}
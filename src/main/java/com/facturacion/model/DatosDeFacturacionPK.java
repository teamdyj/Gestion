package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the datos_de_facturacion database table.
 * 
 */
@Embeddable
public class DatosDeFacturacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String dni;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	@Column(insertable=false, updatable=false)
	private int usuarios_Rol_idRol;

	public DatosDeFacturacionPK() {
	}
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
		if (!(other instanceof DatosDeFacturacionPK)) {
			return false;
		}
		DatosDeFacturacionPK castOther = (DatosDeFacturacionPK)other;
		return 
			this.dni.equals(castOther.dni)
			&& this.usuariosEmail.equals(castOther.usuariosEmail)
			&& (this.usuarios_Rol_idRol == castOther.usuarios_Rol_idRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dni.hashCode();
		hash = hash * prime + this.usuariosEmail.hashCode();
		hash = hash * prime + this.usuarios_Rol_idRol;
		
		return hash;
	}
}
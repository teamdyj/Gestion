package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the factura database table.
 * 
 */
@Embeddable
public class FacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int nºfactura;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	@Column(insertable=false, updatable=false)
	private int usuarios_Rol_idRol;

	public FacturaPK() {
	}
	public int getNºfactura() {
		return this.nºfactura;
	}
	public void setNºfactura(int nºfactura) {
		this.nºfactura = nºfactura;
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
		if (!(other instanceof FacturaPK)) {
			return false;
		}
		FacturaPK castOther = (FacturaPK)other;
		return 
			(this.nºfactura == castOther.nºfactura)
			&& this.usuariosEmail.equals(castOther.usuariosEmail)
			&& (this.usuarios_Rol_idRol == castOther.usuarios_Rol_idRol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nºfactura;
		hash = hash * prime + this.usuariosEmail.hashCode();
		hash = hash * prime + this.usuarios_Rol_idRol;
		
		return hash;
	}
}
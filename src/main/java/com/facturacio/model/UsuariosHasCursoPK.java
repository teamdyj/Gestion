package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios_has_cursos database table.
 * 
 */
@Embeddable
public class UsuariosHasCursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	@Column(insertable=false, updatable=false)
	private int usuarios_Rol_idRol;

	@Column(insertable=false, updatable=false)
	private int cursos_idCursos;

	public UsuariosHasCursoPK() {
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
	public int getCursos_idCursos() {
		return this.cursos_idCursos;
	}
	public void setCursos_idCursos(int cursos_idCursos) {
		this.cursos_idCursos = cursos_idCursos;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosHasCursoPK)) {
			return false;
		}
		UsuariosHasCursoPK castOther = (UsuariosHasCursoPK)other;
		return 
			this.usuariosEmail.equals(castOther.usuariosEmail)
			&& (this.usuarios_Rol_idRol == castOther.usuarios_Rol_idRol)
			&& (this.cursos_idCursos == castOther.cursos_idCursos);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuariosEmail.hashCode();
		hash = hash * prime + this.usuarios_Rol_idRol;
		hash = hash * prime + this.cursos_idCursos;
		
		return hash;
	}
}
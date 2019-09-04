package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cursos_has_asignaturas database table.
 * 
 */
@Embeddable
public class CursosHasAsignaturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int cursos_idCursos;

	@Column(insertable=false, updatable=false)
	private int asignaturas_idAsignaturas;

	public CursosHasAsignaturaPK() {
	}
	public int getCursos_idCursos() {
		return this.cursos_idCursos;
	}
	public void setCursos_idCursos(int cursos_idCursos) {
		this.cursos_idCursos = cursos_idCursos;
	}
	public int getAsignaturas_idAsignaturas() {
		return this.asignaturas_idAsignaturas;
	}
	public void setAsignaturas_idAsignaturas(int asignaturas_idAsignaturas) {
		this.asignaturas_idAsignaturas = asignaturas_idAsignaturas;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursosHasAsignaturaPK)) {
			return false;
		}
		CursosHasAsignaturaPK castOther = (CursosHasAsignaturaPK)other;
		return 
			(this.cursos_idCursos == castOther.cursos_idCursos)
			&& (this.asignaturas_idAsignaturas == castOther.asignaturas_idAsignaturas);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cursos_idCursos;
		hash = hash * prime + this.asignaturas_idAsignaturas;
		
		return hash;
	}
}
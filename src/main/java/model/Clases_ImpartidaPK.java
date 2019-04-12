package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Clases_Impartidas database table.
 * 
 */
@Embeddable
public class Clases_ImpartidaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idClases_Impartidas;

	@Column(insertable=false, updatable=false)
	private int cursos_has_Asignaturas_Asignaturas_idAsignaturas;

	@Column(insertable=false, updatable=false)
	private int cursos_has_Asignaturas_Cursos_idCursos;

	public Clases_ImpartidaPK() {
	}
	public int getIdClases_Impartidas() {
		return this.idClases_Impartidas;
	}
	public void setIdClases_Impartidas(int idClases_Impartidas) {
		this.idClases_Impartidas = idClases_Impartidas;
	}
	public int getCursos_has_Asignaturas_Asignaturas_idAsignaturas() {
		return this.cursos_has_Asignaturas_Asignaturas_idAsignaturas;
	}
	public void setCursos_has_Asignaturas_Asignaturas_idAsignaturas(int cursos_has_Asignaturas_Asignaturas_idAsignaturas) {
		this.cursos_has_Asignaturas_Asignaturas_idAsignaturas = cursos_has_Asignaturas_Asignaturas_idAsignaturas;
	}
	public int getCursos_has_Asignaturas_Cursos_idCursos() {
		return this.cursos_has_Asignaturas_Cursos_idCursos;
	}
	public void setCursos_has_Asignaturas_Cursos_idCursos(int cursos_has_Asignaturas_Cursos_idCursos) {
		this.cursos_has_Asignaturas_Cursos_idCursos = cursos_has_Asignaturas_Cursos_idCursos;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Clases_ImpartidaPK)) {
			return false;
		}
		Clases_ImpartidaPK castOther = (Clases_ImpartidaPK)other;
		return 
			(this.idClases_Impartidas == castOther.idClases_Impartidas)
			&& (this.cursos_has_Asignaturas_Asignaturas_idAsignaturas == castOther.cursos_has_Asignaturas_Asignaturas_idAsignaturas)
			&& (this.cursos_has_Asignaturas_Cursos_idCursos == castOther.cursos_has_Asignaturas_Cursos_idCursos);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idClases_Impartidas;
		hash = hash * prime + this.cursos_has_Asignaturas_Asignaturas_idAsignaturas;
		hash = hash * prime + this.cursos_has_Asignaturas_Cursos_idCursos;
		
		return hash;
	}
}
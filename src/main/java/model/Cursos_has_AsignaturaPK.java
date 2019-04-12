package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Cursos_has_Asignaturas database table.
 * 
 */
@Embeddable
public class Cursos_has_AsignaturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int cursos_idCursos;

	@Column(insertable=false, updatable=false)
	private int asignaturas_idAsignaturas;

	@Column(insertable=false, updatable=false)
	private int precios_idPrecios;

	@Column(name="usuarios_email", insertable=false, updatable=false)
	private String usuariosEmail;

	public Cursos_has_AsignaturaPK() {
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
	public int getPrecios_idPrecios() {
		return this.precios_idPrecios;
	}
	public void setPrecios_idPrecios(int precios_idPrecios) {
		this.precios_idPrecios = precios_idPrecios;
	}
	public String getUsuariosEmail() {
		return this.usuariosEmail;
	}
	public void setUsuariosEmail(String usuariosEmail) {
		this.usuariosEmail = usuariosEmail;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Cursos_has_AsignaturaPK)) {
			return false;
		}
		Cursos_has_AsignaturaPK castOther = (Cursos_has_AsignaturaPK)other;
		return 
			(this.cursos_idCursos == castOther.cursos_idCursos)
			&& (this.asignaturas_idAsignaturas == castOther.asignaturas_idAsignaturas)
			&& (this.precios_idPrecios == castOther.precios_idPrecios)
			&& this.usuariosEmail.equals(castOther.usuariosEmail);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cursos_idCursos;
		hash = hash * prime + this.asignaturas_idAsignaturas;
		hash = hash * prime + this.precios_idPrecios;
		hash = hash * prime + this.usuariosEmail.hashCode();
		
		return hash;
	}
}
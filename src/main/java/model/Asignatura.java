package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Asignaturas database table.
 * 
 */
@Entity
@Table(name="Asignaturas")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAsignaturas;

	private String curriculu;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Cursos_has_Asignatura
	@OneToMany(mappedBy="asignatura")
	private List<Cursos_has_Asignatura> cursosHasAsignaturas;

	public Asignatura() {
	}

	public int getIdAsignaturas() {
		return this.idAsignaturas;
	}

	public void setIdAsignaturas(int idAsignaturas) {
		this.idAsignaturas = idAsignaturas;
	}

	public String getCurriculu() {
		return this.curriculu;
	}

	public void setCurriculu(String curriculu) {
		this.curriculu = curriculu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cursos_has_Asignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<Cursos_has_Asignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public Cursos_has_Asignatura addCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setAsignatura(this);

		return cursosHasAsignatura;
	}

	public Cursos_has_Asignatura removeCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setAsignatura(null);

		return cursosHasAsignatura;
	}

}
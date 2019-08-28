package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cursos database table.
 * 
 */
@Entity
@Table(name="Cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCursos;

	private String curricului;

	private String curso;

	private String descripcion;

	//bi-directional many-to-one association to Cursos_has_Asignatura
	@OneToMany(mappedBy="curso")
	private List<Cursos_has_Asignatura> cursosHasAsignaturas;

	public Curso() {
	}

	public int getIdCursos() {
		return this.idCursos;
	}

	public void setIdCursos(int idCursos) {
		this.idCursos = idCursos;
	}

	public String getCurricului() {
		return this.curricului;
	}

	public void setCurricului(String curricului) {
		this.curricului = curricului;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cursos_has_Asignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<Cursos_has_Asignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public Cursos_has_Asignatura addCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setCurso(this);

		return cursosHasAsignatura;
	}

	public Cursos_has_Asignatura removeCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setCurso(null);

		return cursosHasAsignatura;
	}

}
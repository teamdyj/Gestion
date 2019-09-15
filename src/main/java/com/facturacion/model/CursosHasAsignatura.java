package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cursos_has_asignaturas database table.
 * 
 */
@Entity
@Table(name="cursos_has_asignaturas")
@NamedQuery(name="CursosHasAsignatura.findAll", query="SELECT c FROM CursosHasAsignatura c")
public class CursosHasAsignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursosHasAsignaturaPK id;

	@Lob
	private byte[] curriculu;

	private String descripcion;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="Asignaturas_idAsignaturas")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="Cursos_idCursos")
	private Curso curso;

	public CursosHasAsignatura() {
	}

	public CursosHasAsignaturaPK getId() {
		return this.id;
	}

	public void setId(CursosHasAsignaturaPK id) {
		this.id = id;
	}

	public byte[] getCurriculu() {
		return this.curriculu;
	}

	public void setCurriculu(byte[] curriculu) {
		this.curriculu = curriculu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
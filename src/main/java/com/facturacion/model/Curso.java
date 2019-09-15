package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cursos database table.
 * 
 */
@Entity
@Table(name="cursos")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCursos;

	private String curso;

	private String descripcion;

	public Curso() {
	}

	public int getIdCursos() {
		return this.idCursos;
	}

	public void setIdCursos(int idCursos) {
		this.idCursos = idCursos;
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

}
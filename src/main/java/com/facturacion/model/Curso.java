package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to CursosHasAsignatura
	@OneToMany(mappedBy="curso")
	private List<CursosHasAsignatura> cursosHasAsignaturas;

	//bi-directional many-to-one association to UsuariosHasCurso
	@OneToMany(mappedBy="curso")
	private List<UsuariosHasCurso> usuariosHasCursos;

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

	public List<CursosHasAsignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<CursosHasAsignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public CursosHasAsignatura addCursosHasAsignatura(CursosHasAsignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setCurso(this);

		return cursosHasAsignatura;
	}

	public CursosHasAsignatura removeCursosHasAsignatura(CursosHasAsignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setCurso(null);

		return cursosHasAsignatura;
	}

	public List<UsuariosHasCurso> getUsuariosHasCursos() {
		return this.usuariosHasCursos;
	}

	public void setUsuariosHasCursos(List<UsuariosHasCurso> usuariosHasCursos) {
		this.usuariosHasCursos = usuariosHasCursos;
	}

	public UsuariosHasCurso addUsuariosHasCurso(UsuariosHasCurso usuariosHasCurso) {
		getUsuariosHasCursos().add(usuariosHasCurso);
		usuariosHasCurso.setCurso(this);

		return usuariosHasCurso;
	}

	public UsuariosHasCurso removeUsuariosHasCurso(UsuariosHasCurso usuariosHasCurso) {
		getUsuariosHasCursos().remove(usuariosHasCurso);
		usuariosHasCurso.setCurso(null);

		return usuariosHasCurso;
	}

}
package com.facturacio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignaturas database table.
 * 
 */
@Entity
@Table(name="asignaturas")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAsignaturas;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to CursosHasAsignatura
	@OneToMany(mappedBy="asignatura")
	private List<CursosHasAsignatura> cursosHasAsignaturas;

	public Asignatura() {
	}

	public int getIdAsignaturas() {
		return this.idAsignaturas;
	}

	public void setIdAsignaturas(int idAsignaturas) {
		this.idAsignaturas = idAsignaturas;
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

	public List<CursosHasAsignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<CursosHasAsignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public CursosHasAsignatura addCursosHasAsignatura(CursosHasAsignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setAsignatura(this);

		return cursosHasAsignatura;
	}

	public CursosHasAsignatura removeCursosHasAsignatura(CursosHasAsignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setAsignatura(null);

		return cursosHasAsignatura;
	}

}
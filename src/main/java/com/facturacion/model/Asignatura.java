package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


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

}
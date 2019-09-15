package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clases database table.
 * 
 */
@Entity
@Table(name="clases")
@NamedQuery(name="Clas.findAll", query="SELECT c FROM Clas c")
public class Clas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idClases;

	private String descripcion;

	private float duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Clas() {
	}

	public int getIdClases() {
		return this.idClases;
	}

	public void setIdClases(int idClases) {
		this.idClases = idClases;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getDuracion() {
		return this.duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
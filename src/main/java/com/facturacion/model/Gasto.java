package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gastos database table.
 * 
 */
@Entity
@Table(name="gastos")
@NamedQuery(name="Gasto.findAll", query="SELECT g FROM Gasto g")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGastos;

	private String descripción;

	private String enlace;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float importe;

	public Gasto() {
	}

	public int getIdGastos() {
		return this.idGastos;
	}

	public void setIdGastos(int idGastos) {
		this.idGastos = idGastos;
	}

	public String getDescripción() {
		return this.descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public String getEnlace() {
		return this.enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return this.importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

}
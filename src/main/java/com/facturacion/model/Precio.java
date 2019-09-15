package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the precios database table.
 * 
 */
@Entity
@Table(name="precios")
@NamedQuery(name="Precio.findAll", query="SELECT p FROM Precio p")
public class Precio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrecios;

	private BigDecimal factor;

	private BigDecimal impuestos;

	private float precioFinal;

	public Precio() {
	}

	public int getIdPrecios() {
		return this.idPrecios;
	}

	public void setIdPrecios(int idPrecios) {
		this.idPrecios = idPrecios;
	}

	public BigDecimal getFactor() {
		return this.factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getImpuestos() {
		return this.impuestos;
	}

	public void setImpuestos(BigDecimal impuestos) {
		this.impuestos = impuestos;
	}

	public float getPrecioFinal() {
		return this.precioFinal;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

}
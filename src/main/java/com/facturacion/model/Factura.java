package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nºfactura;

	private int id_clase;

	public Factura() {
	}

	public int getNºfactura() {
		return this.nºfactura;
	}

	public void setNºfactura(int nºfactura) {
		this.nºfactura = nºfactura;
	}

	public int getId_clase() {
		return this.id_clase;
	}

	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}

}
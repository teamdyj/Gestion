package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nºfactura;

	@Column(name="`Datos de facturacion_dni`")
	private String datos_de_facturacion_dni;

	private int id_clase;

	//bi-directional many-to-one association to Clases_Impartida
	@OneToMany(mappedBy="factura")
	private List<Clases_Impartida> clasesImpartidas;

	public Factura() {
	}

	public int getNºfactura() {
		return this.nºfactura;
	}

	public void setNºfactura(int nºfactura) {
		this.nºfactura = nºfactura;
	}

	public String getDatos_de_facturacion_dni() {
		return this.datos_de_facturacion_dni;
	}

	public void setDatos_de_facturacion_dni(String datos_de_facturacion_dni) {
		this.datos_de_facturacion_dni = datos_de_facturacion_dni;
	}

	public int getId_clase() {
		return this.id_clase;
	}

	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}

	public List<Clases_Impartida> getClasesImpartidas() {
		return this.clasesImpartidas;
	}

	public void setClasesImpartidas(List<Clases_Impartida> clasesImpartidas) {
		this.clasesImpartidas = clasesImpartidas;
	}

	public Clases_Impartida addClasesImpartida(Clases_Impartida clasesImpartida) {
		getClasesImpartidas().add(clasesImpartida);
		clasesImpartida.setFactura(this);

		return clasesImpartida;
	}

	public Clases_Impartida removeClasesImpartida(Clases_Impartida clasesImpartida) {
		getClasesImpartidas().remove(clasesImpartida);
		clasesImpartida.setFactura(null);

		return clasesImpartida;
	}

}
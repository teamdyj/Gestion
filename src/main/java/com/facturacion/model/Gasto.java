package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Gastos database table.
 * 
 */
@Entity
@Table(name="Gastos")
@NamedQuery(name="Gasto.findAll", query="SELECT g FROM Gasto g")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGastos;

	private String enlace;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float importe;

	@Column(name="`Tipo_id _tipo`")
	private String tipo_id__tipo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne 
	@JoinColumn(name="usuarios_email")
	private Usuario usuario;

	public Gasto() {
	}

	public int getIdGastos() {
		return this.idGastos;
	}

	public void setIdGastos(int idGastos) {
		this.idGastos = idGastos;
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

	public String getTipo_id__tipo() {
		return this.tipo_id__tipo;
	}

	public void setTipo_id__tipo(String tipo_id__tipo) {
		this.tipo_id__tipo = tipo_id__tipo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
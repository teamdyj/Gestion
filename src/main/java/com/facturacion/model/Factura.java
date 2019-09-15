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

	@EmbeddedId
	private FacturaPK id;

	private int id_clase;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="usuarios_email", referencedColumnName="email"),
		@JoinColumn(name="usuarios_Rol_idRol", referencedColumnName="Rol_idRol")
		})
	private Usuario usuario;

	public Factura() {
	}

	public FacturaPK getId() {
		return this.id;
	}

	public void setId(FacturaPK id) {
		this.id = id;
	}

	public int getId_clase() {
		return this.id_clase;
	}

	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPK id;

	private String apellido;

	private Timestamp fecharegistro;

	private String nombre;

	//bi-directional many-to-one association to Clas
	@OneToMany(mappedBy="usuario")
	private List<Clas> clases;

	//bi-directional many-to-one association to DatosDeFacturacion
	@OneToMany(mappedBy="usuario")
	private List<DatosDeFacturacion> datosDeFacturacions;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="usuario")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Gasto
	@OneToMany(mappedBy="usuario")
	private List<Gasto> gastos;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	private Rol rol;

	//bi-directional many-to-one association to UsuariosHasCurso
	@OneToMany(mappedBy="usuario")
	private List<UsuariosHasCurso> usuariosHasCursos;

	//bi-directional many-to-many association to Precio
	@ManyToMany
	@JoinTable(
		name="usuarios_has_precios"
		, joinColumns={
			@JoinColumn(name="usuarios_email", referencedColumnName="email"),
			@JoinColumn(name="usuarios_Rol_idRol", referencedColumnName="Rol_idRol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="precios_idPrecios")
			}
		)
	private List<Precio> precios;

	public Usuario() {
	}

	public UsuarioPK getId() {
		return this.id;
	}

	public void setId(UsuarioPK id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Clas> getClases() {
		return this.clases;
	}

	public void setClases(List<Clas> clases) {
		this.clases = clases;
	}

	public Clas addClas(Clas clas) {
		getClases().add(clas);
		clas.setUsuario(this);

		return clas;
	}

	public Clas removeClas(Clas clas) {
		getClases().remove(clas);
		clas.setUsuario(null);

		return clas;
	}

	public List<DatosDeFacturacion> getDatosDeFacturacions() {
		return this.datosDeFacturacions;
	}

	public void setDatosDeFacturacions(List<DatosDeFacturacion> datosDeFacturacions) {
		this.datosDeFacturacions = datosDeFacturacions;
	}

	public DatosDeFacturacion addDatosDeFacturacion(DatosDeFacturacion datosDeFacturacion) {
		getDatosDeFacturacions().add(datosDeFacturacion);
		datosDeFacturacion.setUsuario(this);

		return datosDeFacturacion;
	}

	public DatosDeFacturacion removeDatosDeFacturacion(DatosDeFacturacion datosDeFacturacion) {
		getDatosDeFacturacions().remove(datosDeFacturacion);
		datosDeFacturacion.setUsuario(null);

		return datosDeFacturacion;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setUsuario(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setUsuario(null);

		return factura;
	}

	public List<Gasto> getGastos() {
		return this.gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setUsuario(this);

		return gasto;
	}

	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setUsuario(null);

		return gasto;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<UsuariosHasCurso> getUsuariosHasCursos() {
		return this.usuariosHasCursos;
	}

	public void setUsuariosHasCursos(List<UsuariosHasCurso> usuariosHasCursos) {
		this.usuariosHasCursos = usuariosHasCursos;
	}

	public UsuariosHasCurso addUsuariosHasCurso(UsuariosHasCurso usuariosHasCurso) {
		getUsuariosHasCursos().add(usuariosHasCurso);
		usuariosHasCurso.setUsuario(this);

		return usuariosHasCurso;
	}

	public UsuariosHasCurso removeUsuariosHasCurso(UsuariosHasCurso usuariosHasCurso) {
		getUsuariosHasCursos().remove(usuariosHasCurso);
		usuariosHasCurso.setUsuario(null);

		return usuariosHasCurso;
	}

	public List<Precio> getPrecios() {
		return this.precios;
	}

	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}

}
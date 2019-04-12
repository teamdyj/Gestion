package model;

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

	@Id
	private String email;

	private String apellido;

	private Timestamp fecharegistro;

	private String nombre;

	private String rol;

	//bi-directional many-to-one association to Cursos_has_Asignatura
	@OneToMany(mappedBy="usuario")
	private List<Cursos_has_Asignatura> cursosHasAsignaturas;

	//bi-directional many-to-one association to Datos_de_facturacion
	@OneToMany(mappedBy="usuario")
	private List<Datos_de_facturacion> datosDeFacturacions;

	//bi-directional many-to-one association to Gasto
	@OneToMany(mappedBy="usuario")
	private List<Gasto> gastos;

	public Usuario() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Cursos_has_Asignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<Cursos_has_Asignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public Cursos_has_Asignatura addCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setUsuario(this);

		return cursosHasAsignatura;
	}

	public Cursos_has_Asignatura removeCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setUsuario(null);

		return cursosHasAsignatura;
	}

	public List<Datos_de_facturacion> getDatosDeFacturacions() {
		return this.datosDeFacturacions;
	}

	public void setDatosDeFacturacions(List<Datos_de_facturacion> datosDeFacturacions) {
		this.datosDeFacturacions = datosDeFacturacions;
	}

	public Datos_de_facturacion addDatosDeFacturacion(Datos_de_facturacion datosDeFacturacion) {
		getDatosDeFacturacions().add(datosDeFacturacion);
		datosDeFacturacion.setUsuario(this);

		return datosDeFacturacion;
	}

	public Datos_de_facturacion removeDatosDeFacturacion(Datos_de_facturacion datosDeFacturacion) {
		getDatosDeFacturacions().remove(datosDeFacturacion);
		datosDeFacturacion.setUsuario(null);

		return datosDeFacturacion;
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

}
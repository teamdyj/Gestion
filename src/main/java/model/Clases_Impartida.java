package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Clases_Impartidas database table.
 * 
 */
@Entity
@Table(name="Clases_Impartidas")
@NamedQuery(name="Clases_Impartida.findAll", query="SELECT c FROM Clases_Impartida c")
public class Clases_Impartida implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Clases_ImpartidaPK id;

	private String descripcion;

	private float duracion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float horas;

	//bi-directional many-to-one association to Cursos_has_Asignatura
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Cursos_has_Asignaturas_Asignaturas_idAsignaturas", referencedColumnName="Asignaturas_idAsignaturas"),
		@JoinColumn(name="Cursos_has_Asignaturas_Cursos_idCursos", referencedColumnName="Cursos_idCursos"),
		@JoinColumn(name="Cursos_has_Asignaturas_Precios_idPrecios", referencedColumnName="Precios_idPrecios"),
		@JoinColumn(name="Cursos_has_Asignaturas_usuarios_email", referencedColumnName="usuarios_email")
		})
	private Cursos_has_Asignatura cursosHasAsignatura;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="idClases_Impartidas")
	private Factura factura;

	public Clases_Impartida() {
	}

	public Clases_ImpartidaPK getId() {
		return this.id;
	}

	public void setId(Clases_ImpartidaPK id) {
		this.id = id;
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

	public float getHoras() {
		return this.horas;
	}

	public void setHoras(float horas) {
		this.horas = horas;
	}

	public Cursos_has_Asignatura getCursosHasAsignatura() {
		return this.cursosHasAsignatura;
	}

	public void setCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		this.cursosHasAsignatura = cursosHasAsignatura;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
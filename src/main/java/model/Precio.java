package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the Precios database table.
 * 
 */
@Entity
@Table(name="Precios")
@NamedQuery(name="Precio.findAll", query="SELECT p FROM Precio p")
public class Precio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrecios;

	private String asignatura;

	private BigDecimal factor;

	private BigDecimal impuestos;

	private float precio;

	//bi-directional many-to-one association to Cursos_has_Asignatura
	@OneToMany(mappedBy="precio")
	private List<Cursos_has_Asignatura> cursosHasAsignaturas;

	public Precio() {
	}

	public int getIdPrecios() {
		return this.idPrecios;
	}

	public void setIdPrecios(int idPrecios) {
		this.idPrecios = idPrecios;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
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

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Cursos_has_Asignatura> getCursosHasAsignaturas() {
		return this.cursosHasAsignaturas;
	}

	public void setCursosHasAsignaturas(List<Cursos_has_Asignatura> cursosHasAsignaturas) {
		this.cursosHasAsignaturas = cursosHasAsignaturas;
	}

	public Cursos_has_Asignatura addCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().add(cursosHasAsignatura);
		cursosHasAsignatura.setPrecio(this);

		return cursosHasAsignatura;
	}

	public Cursos_has_Asignatura removeCursosHasAsignatura(Cursos_has_Asignatura cursosHasAsignatura) {
		getCursosHasAsignaturas().remove(cursosHasAsignatura);
		cursosHasAsignatura.setPrecio(null);

		return cursosHasAsignatura;
	}

}
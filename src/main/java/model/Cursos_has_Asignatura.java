package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cursos_has_Asignaturas database table.
 * 
 */
@Entity
@Table(name="Cursos_has_Asignaturas")
@NamedQuery(name="Cursos_has_Asignatura.findAll", query="SELECT c FROM Cursos_has_Asignatura c")
public class Cursos_has_Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Cursos_has_AsignaturaPK id;

	private String id_cursoshasAsig;

	//bi-directional many-to-one association to Clases_Impartida
	@OneToMany(mappedBy="cursosHasAsignatura")
	private List<Clases_Impartida> clasesImpartidas;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="Asignaturas_idAsignaturas")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="Cursos_idCursos")
	private Curso curso;

	//bi-directional many-to-one association to Precio
	@ManyToOne
	@JoinColumn(name="Precios_idPrecios")
	private Precio precio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarios_email")
	private Usuario usuario;

	public Cursos_has_Asignatura() {
	}

	public Cursos_has_AsignaturaPK getId() {
		return this.id;
	}

	public void setId(Cursos_has_AsignaturaPK id) {
		this.id = id;
	}

	public String getId_cursoshasAsig() {
		return this.id_cursoshasAsig;
	}

	public void setId_cursoshasAsig(String id_cursoshasAsig) {
		this.id_cursoshasAsig = id_cursoshasAsig;
	}

	public List<Clases_Impartida> getClasesImpartidas() {
		return this.clasesImpartidas;
	}

	public void setClasesImpartidas(List<Clases_Impartida> clasesImpartidas) {
		this.clasesImpartidas = clasesImpartidas;
	}

	public Clases_Impartida addClasesImpartida(Clases_Impartida clasesImpartida) {
		getClasesImpartidas().add(clasesImpartida);
		clasesImpartida.setCursosHasAsignatura(this);

		return clasesImpartida;
	}

	public Clases_Impartida removeClasesImpartida(Clases_Impartida clasesImpartida) {
		getClasesImpartidas().remove(clasesImpartida);
		clasesImpartida.setCursosHasAsignatura(null);

		return clasesImpartida;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Precio getPrecio() {
		return this.precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
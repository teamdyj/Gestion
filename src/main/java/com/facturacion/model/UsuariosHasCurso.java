package com.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_has_cursos database table.
 * 
 */
@Entity
@Table(name="usuarios_has_cursos")
@NamedQuery(name="UsuariosHasCurso.findAll", query="SELECT u FROM UsuariosHasCurso u")
public class UsuariosHasCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosHasCursoPK id;

	private int anoacademico;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="cursos_idCursos")
	private Curso curso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="usuarios_email", referencedColumnName="email"),
		@JoinColumn(name="usuarios_Rol_idRol", referencedColumnName="Rol_idRol")
		})
	private Usuario usuario;

	public UsuariosHasCurso() {
	}

	public UsuariosHasCursoPK getId() {
		return this.id;
	}

	public void setId(UsuariosHasCursoPK id) {
		this.id = id;
	}

	public int getAnoacademico() {
		return this.anoacademico;
	}

	public void setAnoacademico(int anoacademico) {
		this.anoacademico = anoacademico;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
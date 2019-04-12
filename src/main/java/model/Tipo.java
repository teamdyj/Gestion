package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tipo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="`id _tipo`")
	private String id_Tipo;

	private String tipo;

	public Tipo() {
	}

	public String getId_Tipo() {
		return this.id_Tipo;
	}

	public void setId_Tipo(String id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
package com.facturacion.modelDAO;

import java.util.List;

import com.facturacion.model.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> findAll();
	
	public void crear(Usuario usuario);
	
	public Usuario buscar(String email);

}

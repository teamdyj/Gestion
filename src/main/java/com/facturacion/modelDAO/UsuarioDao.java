package com.facturacion.modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.model.Usuario;
@Repository
public class UsuarioDao implements IUsuarioDao{
    @PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Usuario> findAll() {
		
		return em.createQuery("from Usuario").getResultList();
	}
	@Override
	@Transactional
	public void crear(Usuario usuario) {
		if(!usuario.getEmail().equals(null)) {
			em.merge(usuario);
		}else {
		em.persist(usuario);
		}
	}
	@Override
	public Usuario buscar(String email) {
		
		return em.find(Usuario.class, email);
	}

}

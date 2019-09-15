package com.facturacion.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facturacion.model.Usuario;
import com.facturacion.modelDAO.IUsuarioDao;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioDao usuarioDao;
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios",usuarioDao.findAll());
		
		return "usuario/listar";	
	}
	/**
	 * Creamos objeto usuario que recogerá los datos del formulario
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/crear",method=RequestMethod.GET)
	public String crear(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("titulo", "Crear nuevo Usuario");
		model.addAttribute("usuario", usuario);
		return "usuario/crear";
	
	}
	/**
	 * Metodo que recoge los datos del formulario crear cliente 
	 * la notacion @valid nos indica que atienda a las validaciones 
	 * que se recogen en la clase entity usuario, la clase binding result 
	 * nos permite enviar un mensaje si falla la validacion.
	 * @param usuario
	 * @return
	 */
	
	@PostMapping(value="/crear")
	public String guardar(@Valid Usuario usuario, BindingResult br, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("titulo", "Se ha producido un fallo en la validacion");
			return "usuario/crear";
		}
		usuarioDao.crear(usuario);
		return "redirect:listar";

	}
	
	/**
	 * 	Con path variable recogemos el email de un usuario 
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/crear/{email}")
	public String editar(@PathVariable(value="email") String email,  Model model) {
		
		Usuario usuario= null;
		
		if(!email.equals(null)) {
			usuario =usuarioDao.buscar(email);
		}else {
			return "refirect:/usuario/listar";
		}
		model.addAttribute("titulo", "Editar Cliente" );
		model.addAttribute("usuario", usuario);
		return "usuario/crear";
		
	}
}

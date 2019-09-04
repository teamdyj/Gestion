package com.facturacion.controllers;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.facturacio.model.Usuario;

@Controller
//Implement RequestMapping, to access the controller methods we have to access this rout first
@RequestMapping("app")
public class IndexController {
	//@Value("${aplication.controller.titulo}")
	@Value("${texto.index}")
	private String titulo;
	@Value("${texto.index}")
	private String textoindex;
	//El objeto model de Spring permite pasar atributos a la vista
	//Mapeamos el método a una URL, usamos GEtMApping  porque es un tipo de petición Get
	//Could use PostMapping or RequestMapping or GET, PUT,....
	@GetMapping({"/index","/","","/home"}) 
	//we can to use for mapping (ModelMap or Model) the fires need import the class ModelMap
	public ModelAndView index(ModelAndView mv) {
		//with map the method is model.put
		mv.addObject("titulo", this.titulo);
//		Indicate the name of the view
		mv.setViewName("index");
		return mv;	
//		public String index(Model model) {
//			model.addAttribute("titulo", this.titulo);			
//			return "index";
//				
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Manuel");
		usuario.setApellido("Guzman");
		usuario.setEmail("roolrool.net");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario".concat(" "+usuario.getNombre()+" " +usuario.getApellido()));
		return "perfil";
		
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
//		List<Usuario> usuarios=new ArrayList<>();
//		usuarios.add(new Usuario("Paco", "Lopez", "p@pp.es"));
//		usuarios.add(new Usuario("Paco1", "Lopez1", "p1@pp.es"));
//		usuarios.add(new Usuario("Paco2", "Lopez2", "p2@pp.es"));
		
////		other option
//		List<Usuario> usuarios= Arrays.asList(
//				new Usuario("Paco", "Lopez", "p@pp.es"),
//				new Usuario("Paco1", "Lopez1", "p1@pp.es"),
//				new Usuario("Paco2", "Lopez2", "p2@pp.es"),
//				new Usuario("Roger", "Lire", "Lire@pp.es"));
//		
		
		model.addAttribute("titulo", "Listando a usuarios");
	//	model.addAttribute("usuarios",usuarios);
		return "listar";
		
	}
	
//  another way to pass the parameter into view,In this case we can access the "usuarios" attribute  from all views defined in the ControllerIndex
	
	@ModelAttribute("usuarios")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios= Arrays.asList(
				new Usuario("Paco", "Lopez", "p@pp.es"),
				new Usuario("Paco1", "Lopez1", "p1@pp.es"),
				new Usuario("Paco2", "Lopez2", "p2@pp.es"),
				new Usuario("Roger", "Lire", "Lire@pp.es"));
		return usuarios ;
		
	}

}

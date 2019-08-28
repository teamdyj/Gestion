package com.facturacion.controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@Value("${aplication.controller.titulo}")
	private String titulo;
	//El objeto model de Spring permite pasar atributos a la vista
	//Mapeamos el método a una URL, usamos GEtMApping  porque es un tipo de petición Get
	//P
	@GetMapping("/index") //si fuera post podríamos utilizar postmapping o requestmapping
	public String index(Model model) {
		model.addAttribute("titulo", this.titulo);
		
		return "index";
		
		
	}

}

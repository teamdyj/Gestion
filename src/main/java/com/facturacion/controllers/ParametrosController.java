package com.facturacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parametro")
public class ParametrosController {
	
	@GetMapping("/enviar")
	//This method allows you to send a parameter in the URL
	//Now, we have to make the parameters folder in the templates folder and plce the new view "ver" in this folder
    //	with @RequestParam captured parameter with name texto
	// http://localhost:8080/parametro/enviar?texto=Probando Parámetros
	public String param(@RequestParam(name="texto",defaultValue="pon algún valor") String texto, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: "+ texto);
		return "parametros/ver";
	}
	@GetMapping({"/",""})
	public String index(Model model) {
		
	return "parametros/index";
	}
	

}

package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// marcamos a la clase con controller de spring
@Controller
public class IndexController {
	
	// Inyectamos el objeto model de spring que permite pasarle objetos a la vista
	// Mapeamos el metodo de accion. En este caso sera una llamada get. Tambien se puede usar RequestMapping
	@GetMapping("/index")
	public String index(Model model)
	{
		model.addAttribute("titulo", "Hola Spring Boot");
		// retornamos el mombre de la vista
		return "index";
	}
}

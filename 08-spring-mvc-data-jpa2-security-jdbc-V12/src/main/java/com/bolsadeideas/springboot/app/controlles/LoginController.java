package com.bolsadeideas.springboot.app.controlles;

import java.security.Principal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 
	 * @param error : Es un parametro que nos envia Spring security automaticamente cuando se produce un error en el log in
	 * @param model
	 * @param principal
	 * @param flash
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required = false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash)
	{
		//Si principal es distinto a null, el usuario ya esta loggin
		if(principal != null)
		{
			flash.addFlashAttribute("info", "El usuario ya ha iniciado session");
			return "redirect:/";
		}
		
		if(error != null)
		{
			//pasamos un mensaje de error a la vista
			model.addAttribute("error", "error en el login: Nombre de usuario o password incorrecto");
		}
		
		if(logout != null)
		{
			model.addAttribute("success", "Ha cerrado sesion exitosamente");
		}
		
		return "login";
	}
}

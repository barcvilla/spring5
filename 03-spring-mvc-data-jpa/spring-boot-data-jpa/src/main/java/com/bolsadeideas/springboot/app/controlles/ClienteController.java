package com.bolsadeideas.springboot.app.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;

//Configuramos la clase como un controlador
@Controller
public class ClienteController {
	
	@Autowired //buscamos un componente registrado en el contenedor que implemente la interface IClienteDao
	@Qualifier("clienteDaoJPA") //nos aseguramos de injectar la clase correcta que implemente la interface
	private IClienteDao clienteDao;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String listar(Model model)
	{
		model.addAttribute("titulo", "Listado de Cliente");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
}

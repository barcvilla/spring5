package com.bolsadeideas.springboot.app.controlles;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

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
	
	/**
	 * Metodo request para controlar el ingreso de un nuevo cliente. Mostramos un formulario al usuario.
	 * En la firma de nuestro metodo crear() podemos usar como parametro el objeto Model, pero tambien podemos usar
	 * un objeto de tipo Map<> como se muestra.
	 * La primera face consiste en mostrar el formulario al Usuario. La segunda fase consiste en el envio via submit 
	 * los datos del formulario
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String crear(Map<String, Object> model)
	{
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Clientes");
		return "form";
	}
	
	/**
	 * Metodo que recibe los datos desde el formulario cliente enviado por el usuario
	 * @Valid activa la validacion al objeto mapeado en el form que es el Cliente
	 * BindingResult valida el resultado
	 */
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Formulario de Cliente");
			// si contiene errores retornamos al formulario form
			return "form";
		}
		//llamamos a nuestros clase dao
		clienteDao.save(cliente);
		return "redirect:/listar";
	}
}

package com.bolsadeideas.springboot.backend.apirest.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"}) //direccion a la que se le permite las peticiones, en este caso desde angular
@RestController
@RequestMapping("/api") // requestMaping de primer nivel
public class ClienteRestController {
	
	/**
	 * inyectamos la interface IClienteService cuya implementacion (ClienteServiceImpl) ya es un componente en el contenedor de Spring.
	 * En Spring, cuando se inyecta una interface internamente se llama a la clase concreta que implementa dicha interface.
	 * Si tenemos varias clases concretas que implementen una interface debemos utilizar la anotacion @Qualifier
	 * para indicar la clase concreta que se debe implementar.
	 */
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes") //request mapping de segundo nivel
	public List<Cliente> index()
	{
		return clienteService.findAll();
	}
}

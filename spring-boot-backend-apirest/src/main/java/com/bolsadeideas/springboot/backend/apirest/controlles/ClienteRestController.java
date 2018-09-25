package com.bolsadeideas.springboot.backend.apirest.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id)
	{
		return clienteService.findById(id);
	}
	
	/**
	 * @RequestBody - indica el objeto Cliente que viene desde el front-end en formato Json en el Request
	 */
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente)
	{
		return clienteService.save(cliente);
	}
	
	//@PutMapping permite actualizar un objeto en API REST
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id)
	{
		//obtenemos el cliente a actualizar
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		
		/**
		 * Persistimos el clienteActual con el metodo save() del serviceCliente. Internamente Spring realiza un merge
		 * que actualiza los datos, es decir, realiza un update()
		 * El metodo save() del CrudRepository sirve tanto para realizar un save() como un update(). Realiza un 
		 * insert si el id es null o cero, realiza un merge() si el id no es nulo es decir, el cliente existe
		 * en el contexto de persistencia de Spring
		 */
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id)
	{
		clienteService.delete(id);
	}
}

package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	
	//retornamos una lista de Clientes en la BD
	public List<Cliente> findAll();
	
	//Guardamos y devolvemos el Cliente registrado
	public Cliente save(Cliente cliente);
	
	//encontramos un Cliente por Id
	public Cliente findById(Long id);
	
	//eliminamos un Cliente
	public void delete(Long id);
	
}

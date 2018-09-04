package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	//Metodo findAll() Paginable. Retornamos un tipo Page
	public Page<Cliente> findAll(Pageable pageable);
	
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public void delete(Long id);
}

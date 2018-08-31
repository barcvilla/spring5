package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

/**
 * CrudRepository inteface que implementa las operaciones CRUD.
 * Se pasa una entidad a persistir asi como su ID
 * @author PC
 *
 */
public interface IClienteDao extends CrudRepository<Cliente, Long> {
	
	
}

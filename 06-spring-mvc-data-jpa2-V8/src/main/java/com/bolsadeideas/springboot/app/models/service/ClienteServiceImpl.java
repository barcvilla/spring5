package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IProductoDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Producto;

/**
 * ClienteServiceImpl: representa la clase Facade que es el unico punto de acceso para una clase DAO
 * @author PC
 *
 */
@Service
public class ClienteServiceImpl implements IClienteService {
	
	//Inyectamos el DAO
	@Autowired
	IClienteDao clienteDao;
	
	@Autowired
	IProductoDao productoDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Transactional
	@Override
	public void save(Cliente cliente) {
		
		clienteDao.save(cliente);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Cliente findOne(Long id) {
		
		return clienteDao.findOne(id);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		
		clienteDao.delete(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		//return productoDao.findByNombre(term);
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
	}
	
}

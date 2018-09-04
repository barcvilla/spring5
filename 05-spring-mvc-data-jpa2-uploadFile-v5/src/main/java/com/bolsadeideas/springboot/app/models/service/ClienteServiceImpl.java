package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

/**
 * ClienteServiceImpl: representa la case Facade que es el unico punto de acceso para una clase DAO
 * @author PC
 *
 */
@Service
public class ClienteServiceImpl implements IClienteService {
	
	//Inyectamos el DAO
	@Autowired
	IClienteDao clienteDao;
	
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

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

}

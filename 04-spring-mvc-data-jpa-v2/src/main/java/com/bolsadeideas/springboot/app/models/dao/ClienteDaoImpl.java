package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

//marcamos la clase como componente de persistencia
@Repository //("clienteDaoJPA") 
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() 
	{
		return em.createQuery("from Cliente").getResultList();
	}
	
	/**
	 * Si el id del cliente es distinto de null y el id del cliente es mayor a 0. Entonces se trata de un cliente 
	 * recuperado desd la BD, por lo que la accion a realizar es un update (merge). De lo contrario el id es null por lo que
	 * se trata de un insert (persist)
	 */
	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0)
		{
			em.merge(cliente);
		}
		else
		{
			em.persist(cliente);
		}
		
	}
	
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {
		Cliente cliente = findOne(id);
		em.remove(cliente);
	}
	
	
	
}

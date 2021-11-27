package com.artcruz.ecommerce.iniciandocomjpa;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.EntityManagerTest;
import com.artcruz.ecommerce.model.Cliente;

public class PrimeiroCrudTest extends EntityManagerTest{

	@Test
	public void inserirRegistro() {
		Cliente cliente = new Cliente(1, "Arthur");
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		
		Assert.assertNotNull(clienteVerificacao);
	}
	
	
	@Test
	public void buscarPorIdentificador() {
		Cliente cliente = entityManager.find(Cliente.class, 2);
		
		Assert.assertNotNull(cliente);
		Assert.assertEquals("Pedro", cliente.getNome());
	}
	
	@Test
	public void atualizarRegistros() {
		Cliente cliente = new Cliente();
		
		cliente.setId(2);
		cliente.setNome("Daniel");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		
		Assert.assertEquals("Daniel", clienteVerificacao.getNome());
	}
	
	@Test
	public void removerRegistros() {
		Cliente cliente = entityManager.find(Cliente.class, 2);
		
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		Assert.assertNull(entityManager.find(Cliente.class, cliente.getId()));
		
	}
	
	
}

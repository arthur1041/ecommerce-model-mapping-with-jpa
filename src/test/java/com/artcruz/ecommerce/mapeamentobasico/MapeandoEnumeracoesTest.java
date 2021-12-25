package com.artcruz.ecommerce.mapeamentobasico;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.EntityManagerTest;
import com.artcruz.ecommerce.model.Cliente;
import com.artcruz.ecommerce.model.SexoCliente;

public class MapeandoEnumeracoesTest extends EntityManagerTest{

	@Test
	public void testarEnum() {
		Cliente cliente = new Cliente();
		cliente.setId(4);
		cliente.setNome("Zé da Timba");
		cliente.setSexo(SexoCliente.MASCULINO);
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNotNull(clienteVerificacao);
		
	}
	
}

package com.artcruz.ecommerce.iniciandocomjpa;
import org.junit.Test;

import com.artcruz.ecommerce.EntityManagerTest;
import com.artcruz.ecommerce.model.Produto;

import org.junit.Assert;

public class ConsultandoRegistrosTest extends EntityManagerTest {
	
	@Test
	public void buscaPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1);
		
//		Produto produto = entityManager.getReference(Produto.class, 1); //<-- busca referencia e só faz a consulta no banco quando uma propriedade do objeto for usada
		
//		System.out.println("Ainda não buscou");
		
		Assert.assertNotNull(produto);
		Assert.assertEquals("Kindle", produto.getNome());
	}
	
	@Test
	public void atualizarAReferencia() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("Microfone Samson");
		
		entityManager.refresh(produto);
		
		Assert.assertEquals("Kindle", produto.getNome());
		
	}
	
}

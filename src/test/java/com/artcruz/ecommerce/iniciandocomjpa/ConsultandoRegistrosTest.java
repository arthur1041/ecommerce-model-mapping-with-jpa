package com.artcruz.ecommerce.iniciandocomjpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.artcruz.ecommerce.model.Produto;

import org.junit.Assert;

public class ConsultandoRegistrosTest {
	
	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}
	
	@Before
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		entityManager.close();
	}
	
	@Test
	public void buscaPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		Assert.assertNotNull(produto);
	}
	
	
}

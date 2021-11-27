package com.artcruz.ecommerce.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.artcruz.ecommerce.model.Produto;

public class StartPersistenceUnit {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		//Faça seus testes aqui
		entityManager.getTransaction().begin();
		
		Produto produto = new Produto(2, "Xbox", "Console para no man's sky", new BigDecimal(500.0));
		
		produto = entityManager.merge(produto);
	
		entityManager.getTransaction().commit();
		
//		produto = entityManager.find(Produto.class, 1);
		
		System.out.println(produto);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
}

package com.artcruz.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	public Cliente() {
	
	}
	
	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Id
	private Integer id;
	
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

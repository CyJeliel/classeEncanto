package br.com.classeencanto.model.impl;

import javax.persistence.Entity;

@Entity
public class Produto extends AbstractModel{

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

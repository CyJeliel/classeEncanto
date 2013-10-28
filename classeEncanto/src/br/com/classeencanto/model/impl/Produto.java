package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import br.com.classeencanto.model.Model;

@Entity
@Table(name="produto")
public class Produto implements Model{
	@Id
	private Long id;
	private String nome;
	private String resumo;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

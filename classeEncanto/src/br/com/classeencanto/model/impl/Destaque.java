package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="destaque")
public class Destaque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "destaque_seq")
	@SequenceGenerator(name = "destaque_seq", sequenceName = "destaque_id_seq", allocationSize = 1)
	private long id;
	
	private int posicao;
	
	@OneToOne
	private Produto produto;
	
	public Destaque() {
	}
	
	public Destaque(Produto produto) {
		
		this.produto = produto;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void setNome(String nome) {
		produto.setNome(nome);
	}

	public void setResumo(String resumo) {
		produto.setResumo(resumo);
	}

	public void setDescricao(String descricao) {
		produto.setDescricao(descricao);
	}

	public void setLocalizacao(String localizacao) {
		produto.setLocalizacao(localizacao);
	}

	public String getLocalizacao() {
		return produto.getLocalizacao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
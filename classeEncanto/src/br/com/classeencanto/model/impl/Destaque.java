package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="destaque")
public class Destaque extends Produto {

	private int posicao;

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
}
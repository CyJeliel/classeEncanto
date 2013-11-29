package br.com.classeencanto.model.impl;

import java.io.Serializable;


public class UsuarioProdutoId implements Serializable{

	private static final long serialVersionUID = 1L;

	private long usuarioId;

	private long produtoId;

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}

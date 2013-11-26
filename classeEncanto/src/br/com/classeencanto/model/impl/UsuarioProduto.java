package br.com.classeencanto.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lista_de_desejos")
@IdClass(UsuarioProdutoId.class)
public class UsuarioProduto implements br.com.classeencanto.model.Entity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id", insertable = false, updatable = false)
	private long usuarioId;

	@Id
	@Column(name="produto_id", insertable = false, updatable = false)
	private long produtoId;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public long getId() {
		throw new UnsupportedOperationException("Entidade fraca não possui ID.");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {

			return true;
		}
		if (!(obj instanceof UsuarioProduto)) {

			return false;
		}

		UsuarioProduto usuarioProduto = (UsuarioProduto) obj;

		if (this.produto != null && usuarioProduto.getProduto() != null && this.produto.equals(usuarioProduto.getProduto())) {

			if (this.usuario != null && usuarioProduto.getUsuario() != null && this.usuario.equals(usuarioProduto.getUsuario())) {

				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {

		int hash = 31;

		hash += this.produto != null ? this.produto.hashCode() : 0;

		hash += this.usuario != null ? this.usuario.hashCode() : 0;

		return hash;
	}
}

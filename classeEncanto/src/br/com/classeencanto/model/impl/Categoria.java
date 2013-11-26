package br.com.classeencanto.model.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements br.com.classeencanto.model.Entity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "categoria_seq")
	@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_id_seq", allocationSize = 1)
	private long id;

	private String descricao;

	private String tipo;

	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean valida(List<String> feedbacks) {

		boolean valido = true;

		if (descricao == null) {

			feedbacks.add("A descrição da categoria não pode estar em branco.");

			valido = false;
		}

		return valido;
	}

}

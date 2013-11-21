package br.com.classeencanto.model.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements br.com.classeencanto.model.Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_id_seq", allocationSize = 1)
	private long id;

	private String nome;

	private String resumo;

	private String descricao;

	private byte[] imagem;
	
	@ManyToMany
	@JoinTable(name="produto_categoria", joinColumns={@JoinColumn(name="produto_id")}, inverseJoinColumns={@JoinColumn(name="categoria_id")})
	private List<Categoria> categorias;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public boolean valido(List<String> feedbacks) {

		boolean valido = true;

		if (nome == null || nome.isEmpty()) {

			feedbacks.add("O nome do produto não pode estar em branco.");

			valido = false;
		}

		if (resumo == null) {

			feedbacks.add("O resumo do produto não pode estar em branco.");

			valido = false;
		}

		if (descricao == null) {

			feedbacks.add("A descrição do produto não pode estar em branco.");

			valido = false;
		}

		return valido;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}

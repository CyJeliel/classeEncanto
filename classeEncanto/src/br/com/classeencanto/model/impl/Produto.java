package br.com.classeencanto.model.impl;

import static br.com.classeencanto.util.TipoFeedback.ERRO;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.classeencanto.util.Feedback;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_id_seq", allocationSize = 1)
	private long id;

	private String nome;

	private String resumo;

	private String descricao;

	private String localizacao;

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

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public boolean valido(Set<Feedback> feedbacks) {

		boolean valido = true;

		if (nome == null || nome.isEmpty()) {

			feedbacks.add(new Feedback(
					"O nome do produto não pode estar em branco.", ERRO));

			valido = false;
		}

		if (resumo == null) {

			feedbacks.add(new Feedback(
					"O resumo do produto não pode estar em branco.", ERRO));

			valido = false;
		}

		if (descricao == null) {

			feedbacks.add(new Feedback(
					"A descrição do produto não pode estar em branco.", ERRO));

			valido = false;
		}

		if (localizacao == null) {

			feedbacks
					.add(new Feedback(
							"A localização do produto não pode estar em branco.",
							ERRO));

			valido = false;
		}

		return valido;
	}

}

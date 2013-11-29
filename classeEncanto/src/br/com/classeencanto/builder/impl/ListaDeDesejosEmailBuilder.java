package br.com.classeencanto.builder.impl;

import java.util.Set;

import br.com.classeencanto.builder.Builder;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.UsuarioProduto;

public class ListaDeDesejosEmailBuilder implements Builder<String> {

	private Set<UsuarioProduto> listaDeDesejos;

	public ListaDeDesejosEmailBuilder(Set<UsuarioProduto> listaDeDesejos) {

		this.listaDeDesejos = listaDeDesejos;
	}

	@Override
	public String build() {

		StringBuilder emailContent = new StringBuilder(
				"Solicito orçamento para os seguintes itens:\n");

		emailContent.append("Item\t\t\t|Quantidade");

		for (UsuarioProduto usuarioProduto : listaDeDesejos) {

			Produto produto = usuarioProduto.getProduto();

			emailContent.append("\n" + produto.getResumo() + "|"
					+ usuarioProduto.getQuantidade());
		}

		return emailContent.toString();
	}

}

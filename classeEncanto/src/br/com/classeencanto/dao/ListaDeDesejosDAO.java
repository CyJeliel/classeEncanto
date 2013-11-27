package br.com.classeencanto.dao;

import java.util.Set;

import br.com.classeencanto.model.impl.Usuario;
import br.com.classeencanto.model.impl.UsuarioProduto;

public interface ListaDeDesejosDAO extends DAO<UsuarioProduto>{

	Set<UsuarioProduto> findListaDeDesejos(Usuario usuario);

	void addToListaDeDesejos(UsuarioProduto produto);

	Usuario excluirProdutoListaDeDesejos(String idProduto, Usuario usuario);

	void alterarQuantidadeItemListaDeDesejos(UsuarioProduto usuarioProduto);

}

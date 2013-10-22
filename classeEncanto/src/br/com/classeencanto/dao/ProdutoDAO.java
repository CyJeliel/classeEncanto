package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Produto;

public interface ProdutoDAO extends DAO<Produto> {

	List<Long> findProdutosRelacionados(Long idProduto);

}

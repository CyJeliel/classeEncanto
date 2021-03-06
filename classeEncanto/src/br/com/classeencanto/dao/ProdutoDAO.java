package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Produto;

public interface ProdutoDAO extends DAO<Produto> {

	List<Produto> findProdutosRelacionados(Long idProduto);

	List<Produto> findProdutos(Long idCategoria);

	Produto findById(Long idProduto);

	List<Produto> findAll();
}

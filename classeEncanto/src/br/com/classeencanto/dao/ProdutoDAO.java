package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

public interface ProdutoDAO extends DAO<Produto> {

	List<Produto> findProdutosRelacionados(Long idProduto);

	List<Produto> findListaDeDesejos(Usuario usuario);

	List<Produto> addToListaDeDesejos(Produto produto, Usuario usuario);

	List<Produto> findProdutos(Long idCategoria);

	List<Destaque> findListaDeDestaques();

	Destaque findDestaque(Integer posicaoAntiga);

	Produto findById(Long idProduto);
}

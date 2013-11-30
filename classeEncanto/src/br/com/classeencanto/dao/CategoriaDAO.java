package br.com.classeencanto.dao;

import java.util.List;
import java.util.Set;

import br.com.classeencanto.model.impl.Categoria;

public interface CategoriaDAO extends DAO<Categoria>{

	Categoria findById(Long idCategoria);

	List<Categoria> findAll();

	List<Categoria> findByTipo(String string);

	List<Categoria> findByIds(Set<String> gruposDoProduto);

	int count(String string);
}

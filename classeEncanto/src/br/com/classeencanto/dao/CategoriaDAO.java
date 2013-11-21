package br.com.classeencanto.dao;

import java.util.List;

import br.com.classeencanto.model.impl.Categoria;

public interface CategoriaDAO extends DAO<Categoria>{

	Categoria findById(Long idCategoria);

	List<Categoria> findAll();

}

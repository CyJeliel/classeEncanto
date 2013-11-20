package br.com.classeencanto.dao;

import br.com.classeencanto.model.Entity;

/**
 * Interface para classes que acessam o banco de dados.
 * 
 * @author Cindy de Albuquerque
 * 
 * @param <T>
 */
public interface DAO<T extends Entity> {

	T findById(T t);

	void save(T t);

	void merge(T t);

	void delete(T t);

}

package br.com.classeencanto.dao;

import br.com.classeencanto.model.Model;

/**
 * Interface para classes que acessam o banco de dados.
 * 
 * @author Cindy de Albuquerque
 * 
 * @param <T>
 */
public interface DAO<T extends Model> {

	T find(T t);

	T findById(Long id);

	void save(T t);

	void merge(T t);

	void delete(Long id);

}

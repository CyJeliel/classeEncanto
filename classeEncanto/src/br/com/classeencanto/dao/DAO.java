package br.com.classeencanto.dao;


/**
 * Interface para classes que acessam o banco de dados.
 * 
 * @author Cindy de Albuquerque
 * 
 * @param <T>
 */
public interface DAO<T> {

	T find(T t);

	T findById(Long id);

	void save(T t);

	void merge(T t);

	void delete(Long id);

}

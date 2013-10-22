package br.com.classeencanto.dao.impl;

import br.com.classeencanto.dao.DAO;
import br.com.classeencanto.model.Model;

public class AbstractDAO<T extends Model> implements DAO<T> {

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public T find(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}

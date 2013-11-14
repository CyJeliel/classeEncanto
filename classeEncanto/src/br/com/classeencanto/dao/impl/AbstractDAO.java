package br.com.classeencanto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classeencanto.dao.DAO;

public class AbstractDAO<T> implements DAO<T> {

	private EntityManager em;

	public AbstractDAO() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		em = factory.createEntityManager();
	}

	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T t) {

		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
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

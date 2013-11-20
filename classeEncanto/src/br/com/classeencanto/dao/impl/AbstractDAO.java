package br.com.classeencanto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classeencanto.dao.DAO;
import br.com.classeencanto.model.Entity;

public class AbstractDAO<T extends Entity> implements DAO<T> {

	protected EntityManagerFactory factory;

	protected EntityManager em;

	public AbstractDAO() {
	}

	@Override
	public T findById(T t) {

		beginTransaction();

		@SuppressWarnings("unchecked")
		T t1 = (T) em.find(t.getClass(), t.getId());

		return t1;
	}

	protected void beginTransaction() {
		
		factory = Persistence.createEntityManagerFactory("classeEncanto");

		em = factory.createEntityManager();

		em.getTransaction().begin();
	}

	@Override
	public void save(T t) {

		beginTransaction();

		em.persist(t);

		em.getTransaction().commit();
	}

	@Override
	public void merge(T t) {

		beginTransaction();

		em.persist(t);

		em.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T t) {

		beginTransaction();

		t = (T) em.find(t.getClass(), t.getId());

		em.remove(t);
	}
}

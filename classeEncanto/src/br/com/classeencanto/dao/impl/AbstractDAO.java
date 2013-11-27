package br.com.classeencanto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classeencanto.dao.DAO;
import br.com.classeencanto.model.Entity;

public class AbstractDAO<T extends Entity> implements DAO<T> {

	public AbstractDAO() {
	}

	@Override
	public T findById(T t) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");


		EntityManager em = beginTransaction(factory);

		try {

			@SuppressWarnings("unchecked")
			T t1 = (T) em.find(t.getClass(), t.getId());

			return t1;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public void save(T t) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");


		EntityManager em = beginTransaction(factory);

		try {

			em.persist(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public void merge(T t) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			em.merge(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T t) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			t = (T) em.find(t.getClass(), t.getId());

			em.remove(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	protected EntityManager beginTransaction(EntityManagerFactory factory) {

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		return em;
	}

	protected void endTransaction(EntityManager em, EntityManagerFactory factory) {

		em.close();

		factory.close();
	}
}

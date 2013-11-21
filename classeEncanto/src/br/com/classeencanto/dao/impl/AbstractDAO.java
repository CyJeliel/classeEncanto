package br.com.classeencanto.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.classeencanto.dao.DAO;
import br.com.classeencanto.model.Entity;

public class AbstractDAO<T extends Entity> implements DAO<T> {

	private EntityManagerFactory factory;
	
	public AbstractDAO() {
	}

	@Override
	public T findById(T t) {

		EntityManager em = beginTransaction();

		try {

			@SuppressWarnings("unchecked")
			T t1 = (T) em.find(t.getClass(), t.getId());

			return t1;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	@Override
	public void save(T t) {

		EntityManager em = beginTransaction();

		try {

			em.persist(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	@Override
	public void merge(T t) {

		EntityManager em = beginTransaction();

		try {
			
			em.merge(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T t) {
		
		EntityManager em = beginTransaction();

		try {
			
			t = (T) em.find(t.getClass(), t.getId());

			em.remove(t);

			em.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	protected EntityManager beginTransaction() {

		factory = Persistence.createEntityManagerFactory("classeEncanto");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		return em;
	}

	protected void endTransaction(EntityManager em) {

		em.close();

		factory.close();
	}
}

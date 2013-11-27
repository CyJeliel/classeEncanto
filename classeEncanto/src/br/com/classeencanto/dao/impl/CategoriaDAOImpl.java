package br.com.classeencanto.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.model.impl.Categoria;

@Repository
public class CategoriaDAOImpl extends AbstractDAO<Categoria> implements
		CategoriaDAO {

	@Override
	public Categoria findById(Long idCategoria) {

		Categoria categoria = new Categoria();

		categoria.setId(idCategoria);

		categoria = super.findById(categoria);

		return categoria;
	}

	@Override
	public List<Categoria> findAll() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Categoria> criteria = builder
					.createQuery(Categoria.class);

			TypedQuery<Categoria> query = em.createQuery(criteria);

			List<Categoria> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public List<Categoria> findByTipo(String string) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("classeEncanto");


		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Categoria> criteria = builder
					.createQuery(Categoria.class);

			TypedQuery<Categoria> query = em.createQuery(criteria);

			List<Categoria> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public List<Categoria> findByIds(Set<String> ids) {

		List<Categoria> categorias = new ArrayList<>();

		for (String idString : ids) {

			long id;
			try {

				id = Long.parseLong(idString);

			} catch (NumberFormatException e) {

				e.printStackTrace();

				return null;
			}

			Categoria categoria = findById(id);

			categorias.add(categoria);
		}

		return categorias;
	}

}

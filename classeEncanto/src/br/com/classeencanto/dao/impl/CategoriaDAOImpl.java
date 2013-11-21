package br.com.classeencanto.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
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

		EntityManager em = beginTransaction();

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

			endTransaction(em);
		}
	}

}

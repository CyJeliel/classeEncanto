package br.com.classeencanto.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.DestaqueDAO;
import br.com.classeencanto.model.impl.Destaque;

@Repository
public class DestaqueDAOImpl extends AbstractDAO<Destaque> implements
		DestaqueDAO {

	@Override
	public List<Destaque> findListaDeDestaques() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Destaque> criteria = builder
					.createQuery(Destaque.class);

			TypedQuery<Destaque> query = em.createQuery(criteria);

			List<Destaque> result = query.getResultList();

			return result;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public Destaque findDestaque(Integer posicaoAntiga) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Destaque> criteria = builder
					.createQuery(Destaque.class);

			Root<Destaque> destaque = criteria.from(Destaque.class);

			Predicate restricaoDestaque = builder.equal(
					destaque.get("posicao"), posicaoAntiga);

			criteria.distinct(true).where(restricaoDestaque);

			TypedQuery<Destaque> query = em.createQuery(criteria);

			Destaque result = query.getSingleResult();

			return result;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

}

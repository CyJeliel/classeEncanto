package br.com.classeencanto.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Categoria;
import br.com.classeencanto.model.impl.Produto;

@Repository
public class ProdutoDAOImpl extends AbstractDAO<Produto> implements ProdutoDAO {

	@Override
	public List<Produto> findProdutosRelacionados(Long idProduto) {
		// TODO M�TODO EM MOCK

		Produto produto = findById(idProduto);

		List<Categoria> categorias = produto.getCategorias();

		Set<Long> idsCategorias = new HashSet<>();

		for (Categoria categoria : categorias) {

			idsCategorias.add(categoria.getId());
		}

		List<Produto> itensRelacionados = null;

		try {

			itensRelacionados = findProdutosRelacionadosPorCategoria(
					idsCategorias, idProduto);
		} catch (Exception e) {

			itensRelacionados = findAll();
		}

		return itensRelacionados;
	}

	private List<Produto> findProdutosRelacionadosPorCategoria(
			Set<Long> idsCategorias, Long idProduto) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = builder
					.createQuery(Produto.class);

			Root<Produto> produto = criteria.from(Produto.class);

			Join<Produto, Categoria> categoria = produto.join("categorias");

			Predicate restricaoProduto = builder.and(
					categoria.get("id").in(idsCategorias),
					builder.notEqual(produto.get("id"), idProduto));

			criteria.distinct(true).where(restricaoProduto);

			TypedQuery<Produto> query = em.createQuery(criteria);

			List<Produto> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public List<Produto> findProdutos(Long idCategoria) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = builder
					.createQuery(Produto.class);

			Root<Produto> produto = criteria.from(Produto.class);

			Join<Produto, Categoria> categoria = produto.join("categorias");

			Predicate restricaoProduto = builder.equal(categoria.get("id"),
					builder.parameter(Long.class, "idCategoria"));

			criteria.distinct(true).where(restricaoProduto);

			TypedQuery<Produto> query = em.createQuery(criteria);

			query.setParameter("idCategoria", idCategoria);

			List<Produto> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Override
	public Produto findById(Long idProduto) {

		Produto produto = new Produto();

		produto.setId(idProduto);

		produto = super.findById(produto);

		return produto;
	}

	@Override
	public List<Produto> findAll() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Produto> criteria = builder
					.createQuery(Produto.class);

			TypedQuery<Produto> query = em.createQuery(criteria);

			List<Produto> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}
}

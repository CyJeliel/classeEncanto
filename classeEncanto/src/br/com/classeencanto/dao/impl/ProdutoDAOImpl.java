package br.com.classeencanto.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Categoria;
import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

@Repository
public class ProdutoDAOImpl extends AbstractDAO<Produto> implements ProdutoDAO {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public Produto findById(Produto produto) {
		// TODO REMOVER M�TODO

		// Produto produto = new Produto();
		produto.setNome("Bandaid's personalizados 2");
		produto.setResumo("Bandaid's personalizados para Kit Banheiro 2");
		produto.setDescricao("Bandaid's personalizados para Kit Banheiro 2");
		return produto;
	}

	@Override
	public List<Produto> findProdutosRelacionados(Long idProduto) {
		// TODO M�TODO EM MOCK

		Produto produto = findById(idProduto);

		List<Categoria> categorias = produto.getCategorias();

		Set<Long> idsCategorias = new HashSet<>();

		for (Categoria categoria : categorias) {

			idsCategorias.add(categoria.getId());
		}

		List<Produto> itensRelacionados = findProdutosRelacionados(
				idsCategorias, idProduto);

		return itensRelacionados;
	}

	private List<Produto> findProdutosRelacionados(Set<Long> idsCategorias,
			Long idProduto) {

		EntityManager em = beginTransaction();

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

			endTransaction(em);
		}
	}

	@Override
	public List<Produto> findListaDeDesejos(Usuario usuario) {

		usuario = usuarioDao.findById(usuario);

		return usuario.getListaDeDesejos();
	}

	@Override
	public List<Produto> addToListaDeDesejos(Produto produto, Usuario usuario) {

		EntityManager em = beginTransaction();

		List<Produto> listaDeDesejos = null;

		try {

			listaDeDesejos = findListaDeDesejos(usuario);

			listaDeDesejos.add(produto);

			usuario.setListaDeDesejos(listaDeDesejos);

			usuarioDao.merge(usuario);

			em.getTransaction().commit();

		} catch (Exception e) {

			if (!e.getMessage().contains("duplicate key")) {

				e.printStackTrace();

				throw e;

			} else {

				listaDeDesejos.remove(produto);
			}

		} finally {

			endTransaction(em);
		}

		return listaDeDesejos;
	}

	@Override
	public List<Produto> findProdutos(Long idCategoria) {

		EntityManager em = beginTransaction();

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

			endTransaction(em);
		}
	}

	@Override
	public List<Destaque> findListaDeDestaques() {
		// TODO M�TODO EM MOCK

		List<Destaque> listaDeDestaques = new ArrayList<>();

		for (int i = 1; i <= 3; ++i) {

			Destaque destaque = new Destaque(new Produto());

			destaque.setNome("Bandaid's personalizados 2");

			destaque.setResumo("Bandaid's personalizados para Kit Banheiro 2");

			destaque.setDescricao("Bandaid's personalizados para Kit Banheiro 2");

			destaque.setId(Long.valueOf(i));

			destaque.setPosicao(i);

			listaDeDestaques.add(destaque);
		}

		return listaDeDestaques;
	}

	@Override
	public Destaque findDestaque(Integer posicaoAntiga) {

		EntityManager em = super.beginTransaction();

		try {

			Produto produto = em.find(Produto.class, 10l);

			Destaque destaque = new Destaque(produto);

			destaque.setPosicao(1);

			return destaque;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	@Override
	public Produto findById(Long idProduto) {

		Produto produto = new Produto();

		produto.setId(idProduto);

		produto = super.findById(produto);

		return produto;
	}

}

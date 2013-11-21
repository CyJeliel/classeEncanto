package br.com.classeencanto.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

@Repository
public class ProdutoDAOImpl extends AbstractDAO<Produto> implements ProdutoDAO {

	@Override
	public Produto findById(Produto produto) {
		// TODO REMOVER MÉTODO

		// Produto produto = new Produto();
		produto.setNome("Bandaid's personalizados 2");
		produto.setResumo("Bandaid's personalizados para Kit Banheiro 2");
		produto.setDescricao("Bandaid's personalizados para Kit Banheiro 2");
		return produto;
	}

	@Override
	public List<Long> findProdutosRelacionados(Long idProduto) {
		// TODO MÉTODO EM MOCK

		List<Long> itensRelacionados = new ArrayList<>();
		itensRelacionados.add(2L);
		itensRelacionados.add(3L);
		itensRelacionados.add(4L);
		itensRelacionados.add(5L);
		return itensRelacionados;
	}

	@Override
	public List<Produto> findListaDeDesejos(Usuario usuario) {
		// TODO MÉTODO EM MOCK

		List<Produto> listaDeDesejos = new ArrayList<>();

		Produto produto1 = new Produto();

		produto1.setId(1l);

		Produto produto = findById(produto1);

		listaDeDesejos.add(produto);

		Produto produto3 = new Produto();

		produto1.setId(2l);

		Produto produto2 = findById(produto3);

		listaDeDesejos.add(produto2);

		return listaDeDesejos;
	}

	@Override
	public List<Produto> addToListaDeDesejos(Produto produto, Usuario usuario) {
		// TODO MÉTODO EM MOCK
		List<Produto> listaDeDesejos = findListaDeDesejos(usuario);

		listaDeDesejos.add(produto);

		return listaDeDesejos;
	}

	@Override
	public List<Produto> findProdutos(Long idCategoria) {

		EntityManager em = beginTransaction();

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

			endTransaction(em);
		}
	}

	@Override
	public List<Destaque> findListaDeDestaques() {
		// TODO MÉTODO EM MOCK

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

package br.com.classeencanto.dao.impl;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.classeencanto.dao.ListaDeDesejosDAO;
import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;
import br.com.classeencanto.model.impl.UsuarioProduto;

@Component
public class ListaDeDesejosDAOImpl extends AbstractDAO<UsuarioProduto>
		implements ListaDeDesejosDAO {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public Set<UsuarioProduto> findListaDeDesejos(Usuario usuario) {

		return usuario.getListaDeDesejos();
	}

	@Override
	public void addToListaDeDesejos(UsuarioProduto usuarioProduto) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		Set<UsuarioProduto> listaDeDesejos = null;

		try {

			Usuario usuario = usuarioProduto.getUsuario();

			listaDeDesejos = findListaDeDesejos(usuario);

			if (!listaDeDesejos.contains(usuarioProduto)) {

				listaDeDesejos.add(usuarioProduto);
			}

			usuario.setListaDeDesejos(listaDeDesejos);

			usuarioDao.merge(usuario);

			usuarioProduto.setUsuario(usuario);

			em.getTransaction().commit();

		} catch (Exception e) {

			if (!e.getMessage().contains("duplicate key")) {

				e.printStackTrace();

				throw e;

			} else {

				listaDeDesejos.remove(usuarioProduto);
			}

		} finally {

			endTransaction(em, factory);
		}

	}

	@Override
	public Usuario excluirProdutoListaDeDesejos(String idProduto,
			Usuario usuario) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			Set<UsuarioProduto> listaDeDesejos = usuario.getListaDeDesejos();

			if (listaDeDesejos != null && !listaDeDesejos.isEmpty()) {

				for (UsuarioProduto usuarioProduto : listaDeDesejos) {

					if (idProduto.equals(usuarioProduto.getProduto().getId()
							+ "")) {

						delete(usuarioProduto);

						em.getTransaction().commit();

						em = beginTransaction(factory);

						usuario = usuarioDao.findByLoginSenha(usuario);

						listaDeDesejos = findListaDeDesejos(usuario);

						usuario.setListaDeDesejos(listaDeDesejos);
					}
				}
			}

			em.getTransaction().commit();

			return usuario;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}

	}

	@Override
	public void alterarQuantidadeItemListaDeDesejos(
			UsuarioProduto usuarioProduto) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			Set<UsuarioProduto> listaDeDesejos = usuarioProduto.getUsuario()
					.getListaDeDesejos();

			if (listaDeDesejos != null && !listaDeDesejos.isEmpty()) {

				for (UsuarioProduto usuarioProdutoExistente : listaDeDesejos) {

					if (usuarioProdutoExistente.getProduto().getId() == usuarioProduto
							.getProduto().getId()) {

						usuarioProdutoExistente.setQuantidade(usuarioProduto
								.getQuantidade());

						merge(usuarioProdutoExistente);

						break;
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}

	@Deprecated
	public UsuarioProduto findById(UsuarioProduto t) {

		throw new UnsupportedOperationException("Entidade fraca não possui ID.");
	}

	@Deprecated
	public void save(UsuarioProduto t) {

		throw new UnsupportedOperationException(
				"Entidade fraca é salva pelo objeto pai.");
	}

	public void delete(UsuarioProduto usuarioProduto) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("classeEncanto");

		EntityManager em = beginTransaction(factory);

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<UsuarioProduto> criteria = builder
					.createQuery(UsuarioProduto.class);

			Root<UsuarioProduto> usuarioProdutoRoot = criteria
					.from(UsuarioProduto.class);

			Join<UsuarioProduto, Produto> produto = usuarioProdutoRoot
					.join("produto");

			Join<UsuarioProduto, Usuario> usuario = usuarioProdutoRoot
					.join("usuario");

			Predicate restricaoUsuarioProduto = builder.and(builder.equal(
					produto.get("id"), usuarioProduto.getProduto().getId()),
					builder.equal(usuario.get("id"), usuarioProduto
							.getUsuario().getId()));

			criteria.distinct(true).where(restricaoUsuarioProduto);

			TypedQuery<UsuarioProduto> query = em.createQuery(criteria);

			usuarioProduto = query.getSingleResult();
			
			em.remove(usuarioProduto);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em, factory);
		}
	}
}

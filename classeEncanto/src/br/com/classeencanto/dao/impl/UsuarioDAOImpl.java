package br.com.classeencanto.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

@Repository
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

	@Override
	public boolean existe(Usuario usuario) {
		// TODO Auto-generated method stub

		Random random = new Random();

		return random.nextBoolean();

	}

	@Override
	public Usuario findByLoginSenha(Usuario usuario) {

		EntityManager em = beginTransaction();

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = builder
					.createQuery(Usuario.class);

			Root<Usuario> usuarioRoot = criteria.from(Usuario.class);

			Predicate restricaoDeUsuarios = builder
					.and(builder.equal(usuarioRoot.get("login"),
							usuario.getLogin()),
							builder.equal(usuarioRoot.get("senha"),
									usuario.getSenha()));

			if (usuario.isAdmin()){

				restricaoDeUsuarios = builder.and(restricaoDeUsuarios, builder.equal(usuarioRoot.get("admin"),
									usuario.isAdmin()));
			}

			criteria.distinct(true).where(restricaoDeUsuarios);

			TypedQuery<Usuario> query = em.createQuery(criteria);

			List<Usuario> resultList = query.getResultList();

			if (resultList != null && !resultList.isEmpty()) {

				usuario = resultList.get(0);

				usuario.setListaDeDesejos(usuario.getListaDeDesejos());

			} else {

				usuario = null;
			}

			return usuario;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

	@Override
	public Usuario findById(Long idUsuario) {

		Usuario usuario = new Usuario();

		usuario.setId(idUsuario);

		usuario = super.findById(usuario);

		return usuario;
	}

	@Override
	public List<Usuario> findAll() {

		EntityManager em = beginTransaction();

		try {

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = builder
					.createQuery(Usuario.class);

			TypedQuery<Usuario> query = em.createQuery(criteria);

			List<Usuario> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			endTransaction(em);
		}
	}

}

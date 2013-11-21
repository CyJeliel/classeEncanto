package br.com.classeencanto.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

			criteria.distinct(true)
					.where(builder.equal(usuarioRoot.get("login"),
							usuario.getLogin()))
					.where(builder.equal(usuarioRoot.get("senha"),
							usuario.getSenha()))
					.where(builder.equal(usuarioRoot.get("admin"),
							usuario.isAdmin()));

			TypedQuery<Usuario> query = em.createQuery(criteria);

			List<Usuario> resultList = query.getResultList();

			if (resultList != null && !resultList.isEmpty()) {

				usuario = resultList.get(0);

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

}

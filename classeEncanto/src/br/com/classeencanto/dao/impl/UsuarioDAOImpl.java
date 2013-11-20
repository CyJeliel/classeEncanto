package br.com.classeencanto.dao.impl;

import java.util.Random;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Administrador;
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
	public Administrador findAdministrador(Administrador administrador) {
		// TODO Auto-generated method stub
		return administrador;
	}

	@Override
	public Usuario findByLoginSenha(Usuario usuario) {
		// TODO MÉTODO EM MOCK

		usuario = new Usuario();

		return usuario;
	}

}

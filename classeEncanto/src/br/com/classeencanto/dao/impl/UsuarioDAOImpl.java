package br.com.classeencanto.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.entity.Usuario;

@Repository
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

	@Override
	public boolean existe(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}

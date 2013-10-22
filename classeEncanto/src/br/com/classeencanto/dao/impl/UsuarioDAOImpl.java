package br.com.classeencanto.dao.impl;

import java.util.Random;

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

}

package br.com.classeencanto.model.impl;

import br.com.classeencanto.dao.UsuarioDAO;

public class Administrador extends Usuario {

	public boolean isAdmin() {
		return super.isAdmin();
	}

	public void setAdmin(boolean admin) {
		super.setAdmin(admin);
	}

	@Override
	public Usuario existe(UsuarioDAO usuarioDAO) {

		if (valido()) {

			this.setAdmin(true);

			return usuarioDAO.findByLoginSenha(this);

		}

		return null;
	}
}

package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.classeencanto.dao.UsuarioDAO;

@Entity
@Table(name = "administrador")
public class Administrador extends Usuario {

	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public boolean existe(UsuarioDAO usuarioDAO) {

		if (valido()) {

			this.setAdmin(true);

			Administrador administrador = usuarioDAO.findAdministrador(this);

			if (administrador != null) {

				return true;
			}
		}

		return false;
	}
}

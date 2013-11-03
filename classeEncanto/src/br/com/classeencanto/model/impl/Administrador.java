package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.Model;

@Entity
@Table(name="administrador")
public class Administrador extends Usuario implements Model {

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

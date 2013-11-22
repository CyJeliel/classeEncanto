package br.com.classeencanto.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;

import br.com.classeencanto.dao.UsuarioDAO;

@Entity
@Table(name = "usuario")
public class Usuario implements br.com.classeencanto.model.Entity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_seq")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	private long id;

	private String login;

	private String senha;

	private String email;

	private boolean admin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean valido() {

		if (login == null || login.isEmpty()) {

			return false;
		}

		if (senha == null || senha.isEmpty()) {

			return false;
		}

		return true;
	}

	public boolean existe(UsuarioDAO usuarioDAO) {

		if (valido()) {

			Usuario usuario = usuarioDAO.findByLoginSenha(this);

			if (usuario != null) {

				return true;
			}
		}

		return false;
	}

	public void adicionar(UsuarioDAO usuarioDAO) {

		usuarioDAO.save(this);
	}

	public boolean validarInsercao(String confirmacaoSenha) {

		if (valido()) {

			EmailValidator emailValidator = new EmailValidator();

			if (senha.equals(confirmacaoSenha)
					&& emailValidator.isValid(email, null)) {

				return true;
			}
		}

		return false;
	}

}

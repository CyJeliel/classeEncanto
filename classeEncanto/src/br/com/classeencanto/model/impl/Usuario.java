package br.com.classeencanto.model.impl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.classeencanto.dao.UsuarioDAO;

@Entity
@Table(name = "usuario")
public class Usuario implements br.com.classeencanto.model.Entity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_seq")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	private long id;

	private String login;

	private String senha;

	private String email;

	private boolean admin;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<UsuarioProduto> listaDeDesejos;

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

	public Set<UsuarioProduto> getListaDeDesejos() {
		return listaDeDesejos;
	}

	public void setListaDeDesejos(Set<UsuarioProduto> listaDeDesejos) {
		this.listaDeDesejos = listaDeDesejos;
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

	public Usuario existe(UsuarioDAO usuarioDAO) {

		if (valido()) {

			return usuarioDAO.findByLoginSenha(this);
		}

		return null;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {

			return true;
		}
		if (!(obj instanceof Usuario)) {

			return false;
		}

		Usuario usuario = (Usuario) obj;

		if (this.id == usuario.getId()) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {

		int hash = 31;

		hash += this.id;

		return hash;
	}

}

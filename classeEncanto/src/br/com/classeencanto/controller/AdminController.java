package br.com.classeencanto.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Administrador;

@Controller
@SessionScoped
public class AdminController extends AbstractLoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping("admin")
	public String login(Administrador administrador) {

		return super.login(administrador, usuarioDAO);
	}

	public boolean isLogado() {

		if (usuario == null) {

			return false;
		}

		return true;
	}

	@Override
	protected String getPaginaDeLogin() {
		return "loginAdmin";
	}

	@Override
	protected String getPaginaDeRetorno() {
		return "redirect:produtoDestaque";
	}
}

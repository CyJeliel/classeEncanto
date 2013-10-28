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

	@RequestMapping({ "/loginAdmin" })
	@Override
	protected String getPaginaDeLogin() {
		return "loginAdmin";
	}

	@Override
	protected String getPaginaDeRetorno() {
		return "redirect:produtoDestaque";
	}

	/*public String execute() {
		return "loginAdmin";
	}*/

	@RequestMapping("logoutAdmin")
	public String logout() {

		return super.logout();
	}
}

package br.com.classeencanto.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Administrador;
import br.com.classeencanto.model.impl.Usuario;

@Controller
@SessionScoped
public class AdminController extends AbstractLoginController implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping("admin")
	public ModelAndView login(Administrador administrador) {

		return super.login(administrador, usuarioDAO);
	}

	@RequestMapping("formAdmin")
	public ModelAndView formAdmin(Administrador administrador) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (isLogado()) {

			mav = new ModelAndView("formAdmin");

			List<String> feedbacks = new ArrayList<>();

			feedbacks.addAll(this.feedbacks);

			mav.addObject("feedbacks", feedbacks);
		}

		feedbacks.clear();

		return mav;
	}

	@Override
	protected String getPaginaDeLogin() {
		return "loginAdmin";
	}

	@Override
	protected String getPaginaDeRetorno() {
		return "redirect:produtoDestaque";
	}

	@RequestMapping("logoutAdmin")
	public String logout() {

		return super.logout();
	}

	@RequestMapping("novoAdministrador")
	public ModelAndView novoAdministrador(Usuario usuario) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (isLogado()) {

			this.logout();

			usuario.setAdmin(true);

			usuarioDAO.save(usuario);

			feedbacks.add("Administrador salvo com sucesso.");

			mav.setViewName("redirect:formAdmin");
		}

		return mav;
	}
}

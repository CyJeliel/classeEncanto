package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.model.impl.Usuario;

public abstract class AbstractLoginController {

	protected Usuario usuario;

	protected List<String> feedbacks;

	public AbstractLoginController() {

		feedbacks = new ArrayList<>();
	}

	public ModelAndView login(Usuario usuario, UsuarioDAO usuarioDAO) {

		feedbacks.clear();

		ModelAndView mav = new ModelAndView();

		String retorno;

		Usuario usuarioDB = usuario.existe(usuarioDAO);

		if (isLogado() || usuarioDB != null) {

			this.usuario = usuarioDB;

			retorno = getPaginaDeRetorno();

		} else {

			String login = usuario.getLogin();

			String senha = usuario.getSenha();

			if ((login != null && !login.isEmpty()) || (senha != null && !senha.isEmpty())) {

				feedbacks.add("Login ou senha incorretos.");

				mav.addObject("feedbacks", feedbacks);
			}

			retorno = getPaginaDeLogin();

		}

		mav.setViewName(retorno);

		return mav;
	}

	public boolean isLogado() {

		if (usuario == null) {

			return false;
		}

		return true;
	}

	public String logout() {

		this.usuario = null;

		return getPaginaDeLogin();
	}

	abstract protected String getPaginaDeLogin();

	abstract protected String getPaginaDeRetorno();

}

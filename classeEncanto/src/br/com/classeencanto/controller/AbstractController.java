package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.model.impl.Categoria;

public abstract class AbstractController {

	@Autowired
	private CategoriaDAO categoriaDao;

	@Autowired
	protected AdminController adminController;

	private List<Categoria> categoriasMenu;

	protected ModelAndView finaliza(ModelAndView mav) {

		mav.addObject("isAdmin", adminController.isLogado());

		mav.addObject("categoriasEventos", getCategoriasMenu());

		return mav;
	}

	public List<Categoria> getCategoriasMenu() {

		if (categoriasMenu == null){

			categoriasMenu = categoriaDao.findAll();
		}

		return categoriasMenu;
	}

}

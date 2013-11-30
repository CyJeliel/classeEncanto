package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.model.impl.Categoria;

public class FinalizaController {

	@Autowired
	private CategoriaDAO categoriaDao;

	@Autowired
	protected AdminController adminController;

	private List<Categoria> categoriasEventos;

	private List<Categoria> categoriasDecoracoes;

	protected ModelAndView finaliza(ModelAndView mav) {

		mav.addObject("isAdmin", adminController.isLogado());

		mav.addObject("categoriasEventos", getCategoriasEventos());

		mav.addObject("categoriasDecoracoes", getCategoriasDecoracoes());

		return mav;
	}

	public List<Categoria> getCategoriasEventos() {

		if (categoriasEventos == null || categoriasEventos.size() != categoriaDao.count("Evento") ){

			categoriasEventos = categoriaDao.findByTipo("Evento");
		}

		return categoriasEventos;
	}

	public List<Categoria> getCategoriasDecoracoes() {

		if (categoriasDecoracoes == null || categoriasDecoracoes.size() != categoriaDao.count("Decoracao")){

			categoriasDecoracoes = categoriaDao.findByTipo("Decoracao");
		}

		return categoriasDecoracoes;
	}

}

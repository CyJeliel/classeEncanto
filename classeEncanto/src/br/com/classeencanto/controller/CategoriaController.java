package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.model.impl.Categoria;

@Controller
public class CategoriaController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private CategoriaDAO categoriaDao;

	private List<String> feedbacks;

	private Categoria categoria;

	public CategoriaController() {

		feedbacks = new ArrayList<>();
	}

	@RequestMapping("listaDeCategorias")
	public ModelAndView listaDeCategorias() {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("listaDeCategorias");

			List<Categoria> listaDeCategorias = categoriaDao.findAll();

			mav.addObject("listaDeCategorias", listaDeCategorias);

			mav.addObject("isAdmin", adminController.isLogado());

		} else {

			mav.setViewName("loginAdmin");
		}

		return mav;
	}

	@RequestMapping("excluirCategoria")
	public String excluirCategoria(Categoria categoria) {

		String retorno;

		if (adminController.isLogado()) {

			categoriaDao.delete(categoria);

			retorno = "redirect:listaDeCategorias";

		} else {

			retorno = "loginAdmin";
		}

		return retorno;
	}

	@RequestMapping({ "/cadastroDeCategoria" })
	public ModelAndView cadastroDeCategoria(String idCategoria) {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("cadastroDeCategoria");

			List<String> feedbacks = new ArrayList<>();

			feedbacks.addAll(this.feedbacks);

			mav.addObject("feedbacks", feedbacks);

			mav.addObject("categoria", categoria);

		} else {

			mav.setViewName("loginAdmin");
		}

		feedbacks.clear();

		categoria = null;

		return mav;
	}

	@RequestMapping("formAlterarDadosCategoria")
	public String formAlterarDadosCategoria(Long idCategoria) {

		String retorno = "redirect:admin";

		if (adminController.isLogado()) {

			categoria = categoriaDao.findById(idCategoria);

			retorno = "redirect:cadastroDeCategoria";
		}

		return retorno;
	}

	@RequestMapping("salvarCategoria")
	public String salvarCategoria(Categoria categoria) {

		String retorno = "redirect:admin";

		if (adminController.isLogado()) {

			feedbacks.clear();

			if (categoria.valida(feedbacks)) {

				if (categoria.getId() != 0) {

					alterarCategoria(categoria);

				} else {

					inserirCategoria(categoria);
				}
			}

			retorno = "redirect:cadastroDeCategoria";
		}

		return retorno;
	}

	private void inserirCategoria(Categoria categoria) {

		categoriaDao.save(categoria);

		feedbacks.add("Categoria salva com sucesso.");
	}

	private void alterarCategoria(Categoria categoria) {

		categoriaDao.merge(categoria);

		feedbacks.add("Categoria alterada com sucesso.");
	}

}

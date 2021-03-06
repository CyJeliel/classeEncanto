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
public class CategoriaController extends FinalizaController {

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

			finaliza(mav);

		} else {

			mav.setViewName("loginAdmin");
		}

		return mav;
	}

	@RequestMapping("excluirCategoria")
	public ModelAndView excluirCategoria(Categoria categoria) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			categoriaDao.delete(categoria);

			mav.setViewName("redirect:listaDeCategorias");
			
			recarregaCategorias();
		}

		finaliza(mav);

		return mav;
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

		finaliza(mav);

		return mav;
	}

	@RequestMapping("formAlterarDadosCategoria")
	public ModelAndView formAlterarDadosCategoria(Long idCategoria) {

		ModelAndView mav = new ModelAndView("redirect:admin");

		if (adminController.isLogado()) {

			categoria = categoriaDao.findById(idCategoria);

			mav.setViewName("redirect:cadastroDeCategoria");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("salvarCategoria")
	public ModelAndView salvarCategoria(Categoria categoria) {

		ModelAndView mav = new ModelAndView("redirect:admin");

		if (adminController.isLogado()) {

			feedbacks.clear();

			mav.setViewName("redirect:cadastroDeCategoria");

			if (categoria.valida(feedbacks)) {

				boolean existeCategoria = existeCategoria(categoria, mav);

				if (!existeCategoria) {

					salvar(categoria);
					
					recarregaCategorias();
				}
			}
		}

		return mav;
	}

	private void salvar(Categoria categoria) {

		if (categoria.getId() != 0) {

			alterarCategoria(categoria);

		} else {

			inserirCategoria(categoria);
		}
	}

	private boolean existeCategoria(Categoria categoria, ModelAndView mav) {

		boolean existeCategoria = false;

		List<Categoria> categoriasExistentes = categoriaDao.findAll();

		if (categoriasExistentes != null && !categoriasExistentes.isEmpty()) {

			for (Categoria categoriaExistente : categoriasExistentes) {

				if (categoriaExistente.getDescricao().equals(
						categoria.getDescricao())) {

					if (categoriaExistente.getId() != categoria.getId()) {

						feedbacks.add("Categoria j� cadastrada.");

						mav.setViewName("redirect:cadastroDeCategoria");

						existeCategoria = true;

						break;
					}
				}
			}
		}

		return existeCategoria;
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

package br.com.classeencanto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.DestaqueDAO;
import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;

@Controller
public class DestaqueController extends AbstractController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private DestaqueDAO destaqueDAO;

	@Autowired
	private ProdutoDAO produtoDao;

	@RequestMapping({ "/", "/home" })
	public ModelAndView produtosEmDestaque() {

		ModelAndView mav = new ModelAndView();

		applyDestaques(mav);

		mav.addObject("isAdmin", adminController.isLogado());

		mav.setViewName("home");

		finaliza(mav);

		return mav;
	}

	@RequestMapping({ "/getDestaquehome" })
	@ResponseBody
	public byte[] produtoEmDestaque(Integer posicao) {

		byte[] image = null;

		Destaque destaque = null;

		try {

			destaque = destaqueDAO.findDestaque(posicao);

		} catch (Exception e) {

			List<Produto> produtos = produtoDao.findProdutos(null);

			if (produtos != null && !produtos.isEmpty()) {

				destaque = new Destaque(produtos.get(0));
			}
		}

		if (destaque.getImagem() != null) {

			image = destaque.getImagem();
		}

		return image;
	}

	@RequestMapping("produtoDestaque")
	public ModelAndView cadastroProdutosEmDestaque(Usuario usuario) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			List<Produto> listaDeProdutos = produtoDao.findAll();

			applyDestaques(mav);

			mav.addObject("listaDeProdutos", listaDeProdutos);

			mav.setViewName("cadastroProdutosEmDestaque");
		} else {

			mav.setViewName("loginAdmin");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("selecionaProduto")
	public ModelAndView selecionaProduto(Destaque destaque) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			Produto produto = produtoDao.findById(destaque.getProduto());

			try {

				Destaque destaqueCadastrado = destaqueDAO.findDestaque(destaque
						.getPosicao());

				destaqueCadastrado.setProduto(produto);

				destaqueDAO.merge(destaqueCadastrado);

			} catch (Exception e) {

				destaqueDAO.save(destaque);
			}

			mav.setViewName("redirect:produtoDestaque");

		} else {

			mav.setViewName("loginAdmin");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("excluirDestaque")
	public ModelAndView excluirDestaque(Destaque destaque) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (adminController.isLogado()) {

			destaqueDAO.delete(destaque);

			mav.setViewName("redirect:produtoDestaque");

		}

		finaliza(mav);

		return mav;
	}

	private void applyDestaques(ModelAndView mav) {

		List<Destaque> listaDeDestaques = destaqueDAO.findListaDeDestaques();

		Destaque destaque1 = null;

		Destaque destaque2 = null;

		Destaque destaque3 = null;

		Destaque destaque4 = null;

		for (Destaque destaque : listaDeDestaques) {
			switch (destaque.getPosicao()) {

			case 1:

				destaque1 = destaque;

				break;

			case 2:

				destaque2 = destaque;

				break;

			case 3:

				destaque3 = destaque;

				break;

			case 4:

				destaque4 = destaque;

				break;
			}
		}

		mav.addObject("destaque1", destaque1);

		mav.addObject("destaque2", destaque2);

		mav.addObject("destaque3", destaque3);

		mav.addObject("destaque4", destaque4);

		mav.addObject("listaDeDestaques", listaDeDestaques);
	}

}

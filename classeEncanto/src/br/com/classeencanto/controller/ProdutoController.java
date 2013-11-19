package br.com.classeencanto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Destaque;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;
import br.com.classeencanto.transformer.ImageTransformer;

@Controller
public class ProdutoController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private LoginController loginController;

	@Autowired
	private ProdutoDAO produtoDao;

	@Autowired
	private ImageTransformer transformer;

	private List<String> feedbacks;

	private Produto produto;

	public ProdutoController() {

		feedbacks = new ArrayList<>();
	}

	@RequestMapping({ "/", "/home" })
	public ModelAndView produtosEmDestaque() {

		ModelAndView mav = new ModelAndView();

		List<Destaque> listaDeDestaques = produtoDao.findListaDeDestaques();

		mav.addObject("listaDeDestaques", listaDeDestaques);

		mav.addObject("isAdmin", adminController.isLogado());

		mav.setViewName("home");

		return mav;
	}

	@RequestMapping({ "/getDestaquehome" })
	@ResponseBody
	public byte[] produtoEmDestaque(Integer posicao) {

		byte[] image = null;

		Destaque destaque = produtoDao.findDestaque(posicao);

		if (destaque != null && destaque.getImagem() != null) {

			image = destaque.getImagem();
		}

		return image;
	}

	@RequestMapping("produtoDestaque")
	public String cadastroProdutosEmDestaque(Usuario usuario) {

		if (adminController.isLogado()) {

			return "cadastroProdutosEmDestaque";
		}

		return "loginAdmin";
	}

	@RequestMapping({ "/cadastroDeProduto" })
	public ModelAndView cadastroDeProduto(String idProduto) {

		ModelAndView mav = new ModelAndView();

		if (adminController.isLogado()) {

			mav.setViewName("cadastroDeProduto");

			List<String> feedbacks = new ArrayList<>();

			feedbacks.addAll(this.feedbacks);

			mav.addObject("feedbacks", feedbacks);

			mav.addObject("produto", produto);

		} else {

			mav.setViewName("loginAdmin");
		}

		feedbacks.clear();

		produto = null;

		return mav;

	}

	@RequestMapping("detalhesDeProduto")
	public ModelAndView detalhesDeProduto(Long idProduto) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("detalhesDeProduto");

		Produto produto = produtoDao.findById(idProduto);

		mav.addObject("produto", produto);

		List<Long> itensRelacionados = produtoDao
				.findProdutosRelacionados(idProduto);

		mav.addObject("itensRelacionados", itensRelacionados);

		mav.addObject("isAdmin", adminController.isLogado());

		return mav;
	}

	@RequestMapping("listaDeDesejos")
	public ModelAndView listaDeDesejos() {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("listaDeDesejos");

			List<Produto> listaDeDesejos = produtoDao
					.findListaDeDesejos(loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);

			mav.addObject("isAdmin", adminController.isLogado());

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("listaDeProdutos")
	public ModelAndView listaDeProdutos() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("listaDeProdutos");

		List<Produto> listaDeProdutos = produtoDao.findProdutos(null);

		mav.addObject("listaDeProdutos", listaDeProdutos);

		mav.addObject("isAdmin", adminController.isLogado());

		return mav;
	}

	@RequestMapping("adicionarListaDeDesejos")
	public ModelAndView adicionarListaDeDesejos(Long produtoId) {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("listaDeDesejos");

			Produto produto = produtoDao.findById(produtoId);

			List<Produto> listaDeDesejos = produtoDao.addToListaDeDesejos(
					produto, loginController.usuario);

			mav.addObject("listaDeDesejos", listaDeDesejos);

		} else {

			mav.setViewName("login");
		}

		return mav;
	}

	@RequestMapping("novoProduto")
	public String novoProduto(Produto produto, HttpServletRequest request) {

		String retorno = "redirect:admin";

		if (adminController.isLogado()) {

			feedbacks.clear();

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

			MultipartFile file = multipartRequest.getFile("arquivo");

			if (file != null) {

				if (produto.valido(feedbacks)) {

					try {
						produto.setImagem(transformer.fileToByte(file));
					} catch (IOException e) {

						e.printStackTrace();

						return retorno;
					}

					produtoDao.save(produto);

					feedbacks.add("Produto salvo com sucesso.");
				}
			} else {

				feedbacks.add("A imagem do produto não pode estar em branco.");
			}

			retorno = "redirect:cadastroDeProduto";
		}

		return retorno;
	}

	@RequestMapping("formAlterarDadosProduto")
	public String formAlterarDadosProduto(Long idProduto) {

		String retorno = "redirect:admin";

		if (adminController.isLogado()) {

			produto = produtoDao.findById(idProduto);

			retorno = "redirect:cadastroDeProduto";
		}

		return retorno;
	}

}
package br.com.classeencanto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.dao.CategoriaDAO;
import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Categoria;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.transformer.ArrayTransformer;
import br.com.classeencanto.transformer.ImageTransformer;

@Controller
public class ProdutoController extends AbstractController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private UsuarioController loginController;

	@Autowired
	private ProdutoDAO produtoDao;

	@Autowired
	private CategoriaDAO categoriaDao;

	@Autowired
	private ImageTransformer transformer;

	@Autowired
	private ArrayTransformer arrayTransformer;

	private List<String> feedbacks;

	private Produto produto;

	public ProdutoController() {

		feedbacks = new ArrayList<>();
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

			List<Categoria> gruposCategoria = categoriaDao.findByTipo("Evento");

			List<Categoria> temasCategoria = categoriaDao
					.findByTipo("Decoracao");

			mav.addObject("gruposCategoria", gruposCategoria);

			mav.addObject("temasCategoria", temasCategoria);

		} else {

			mav.setViewName("loginAdmin");
		}

		feedbacks.clear();

		produto = null;

		finaliza(mav);

		return mav;

	}

	@RequestMapping("detalhesDeProduto")
	public ModelAndView detalhesDeProduto(Long idProduto) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("detalhesDeProduto");

		Produto produto = produtoDao.findById(idProduto);

		mav.addObject("produto", produto);

		List<Produto> itensRelacionados = produtoDao
				.findProdutosRelacionados(idProduto);

		mav.addObject("itensRelacionados", itensRelacionados);

		finaliza(mav);

		return mav;
	}

	@RequestMapping("listaDeProdutos")
	public ModelAndView listaDeProdutos(Long idCategoria) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("listaDeProdutos");

		List<Produto> listaDeProdutos = produtoDao.findProdutos(idCategoria);

		mav.addObject("listaDeProdutos", listaDeProdutos);

		finaliza(mav);

		return mav;
	}

	@RequestMapping("salvarProduto")
	public ModelAndView salvarProduto(Produto produto,
			@RequestParam(value = "grupoDoProduto") String[] grupoDoProduto,
			@RequestParam(value = "temaDoProduto") String[] temaDoProduto,
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("redirect:admin");

		if (adminController.isLogado()) {

			feedbacks.clear();

			if (produto.valido(feedbacks)) {

				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

				MultipartFile file = multipartRequest.getFile("arquivo");

				applyCategorias(produto, grupoDoProduto, temaDoProduto);

				if (produto.getId() != 0) {

					alterarProduto(produto, file);

				} else {

					inserirProduto(produto, file);
				}
			}

			mav.setViewName("redirect:cadastroDeProduto");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("formAlterarDadosProduto")
	public ModelAndView formAlterarDadosProduto(Long idProduto) {

		ModelAndView mav = new ModelAndView("redirect:admin");

		if (adminController.isLogado()) {

			produto = produtoDao.findById(idProduto);

			mav.setViewName("redirect:cadastroDeProduto");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping({ "/getImagemProduto" })
	@ResponseBody
	public byte[] getImagemProduto(Long idProduto) {

		byte[] image = null;

		Produto produto = produtoDao.findById(idProduto);

		if (produto != null && produto.getImagem() != null) {

			image = produto.getImagem();
		}

		return image;
	}

	@RequestMapping("excluirProduto")
	public ModelAndView excluirProduto(Produto produto) {

		produtoDao.delete(produto);

		ModelAndView mav = new ModelAndView("redirect:home");

		finaliza(mav);

		return mav;
	}

	private void applyCategorias(Produto produto, String[] grupoDoProduto,
			String[] temaDoProduto) {

		Set<String> gruposDoProduto = arrayTransformer
				.arrayToSet(grupoDoProduto);

		Set<String> temasDoProduto = arrayTransformer.arrayToSet(temaDoProduto);

		List<Categoria> grupos = categoriaDao.findByIds(gruposDoProduto);

		List<Categoria> temas = categoriaDao.findByIds(temasDoProduto);

		grupos.addAll(temas);

		produto.setCategorias(grupos);
	}

	private void inserirProduto(Produto produto, MultipartFile file) {

		if (file != null) {

			applyImagem(produto, file);

			produtoDao.save(produto);

			feedbacks.add("Produto salvo com sucesso.");

		} else {

			feedbacks.add("A imagem do produto nao pode estar em branco.");
		}
	}

	private void alterarProduto(Produto produto, MultipartFile file) {

		if (file != null) {

			applyImagem(produto, file);

		} else {

			Produto produtoExistente = produtoDao.findById(produto.getId());

			produto.setImagem(produtoExistente.getImagem());
		}

		produtoDao.merge(produto);

		feedbacks.add("Produto alterado com sucesso.");
	}

	private void applyImagem(Produto produto, MultipartFile file) {

		try {

			produto.setImagem(transformer.fileToByte(file));

		} catch (IOException e) {

			e.printStackTrace();

			return;
		}
	}

}

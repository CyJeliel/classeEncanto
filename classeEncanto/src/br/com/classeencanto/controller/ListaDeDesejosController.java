package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.builder.impl.ConnectionPropertiesBuilder;
import br.com.classeencanto.builder.impl.ListaDeDesejosEmailBuilder;
import br.com.classeencanto.builder.impl.MessageBuilder;
import br.com.classeencanto.builder.impl.SessionBuilder;
import br.com.classeencanto.dao.ListaDeDesejosDAO;
import br.com.classeencanto.dao.ProdutoDAO;
import br.com.classeencanto.model.impl.Produto;
import br.com.classeencanto.model.impl.Usuario;
import br.com.classeencanto.model.impl.UsuarioProduto;

@Controller
public class ListaDeDesejosController extends FinalizaController {

	@Autowired
	private AdminController adminController;

	@Autowired
	private UsuarioController loginController;

	@Autowired
	private ListaDeDesejosDAO listaDeDesejosDao;

	@Autowired
	private ProdutoDAO produtoDAO;

	private List<String> feedbacks;

	public ListaDeDesejosController() {

		feedbacks = new ArrayList<>();
	}

	@RequestMapping("listaDeDesejos")
	public ModelAndView listaDeDesejos() {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			Usuario usuario = loginController.usuario;

			if (usuario == null) {

				usuario = adminController.usuario;
			}

			mav.setViewName("listaDeDesejos");

			Set<UsuarioProduto> listaDeDesejos = listaDeDesejosDao
					.findListaDeDesejos(usuario);

			List<String> feedbacks = new ArrayList<>();

			feedbacks.addAll(this.feedbacks);

			mav.addObject("feedbacks", feedbacks);

			this.feedbacks.clear();

			mav.addObject("listaDeDesejos", listaDeDesejos);

		} else {

			mav.setViewName("login");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("adicionarListaDeDesejos")
	public ModelAndView adicionarListaDeDesejos(Long produtoId) {

		ModelAndView mav = new ModelAndView();

		if (loginController.isLogado() || adminController.isLogado()) {

			mav.setViewName("redirect:listaDeDesejos");

			UsuarioProduto usuarioProduto = buildUsuarioProduto(produtoId);

			listaDeDesejosDao.addToListaDeDesejos(usuarioProduto);

		} else {

			mav.setViewName("login");
		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("excluirProdutoListaDeDesejos")
	public ModelAndView excluirProdutoListaDeDesejos(String idProduto) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (loginController.isLogado() || adminController.isLogado()) {

			Usuario usuario = loginController.usuario;

			if (usuario == null) {

				usuario = adminController.usuario;
			}

			usuario = listaDeDesejosDao.excluirProdutoListaDeDesejos(idProduto, usuario);

			if (usuario.isAdmin()) {

				adminController.usuario = usuario;

			}

			loginController.usuario = usuario;

			mav.setViewName("redirect:listaDeDesejos");

		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("alterarQuantidadeItemListaDeDesejos")
	public ModelAndView alterarQuantidadeItemListaDeDesejos(
			UsuarioProduto usuarioProduto) {

		ModelAndView mav = new ModelAndView("loginAdmin");

		if (loginController.isLogado() || adminController.isLogado()) {

			usuarioProduto.setUsuario(loginController.usuario);

			listaDeDesejosDao
					.alterarQuantidadeItemListaDeDesejos(usuarioProduto);

			mav.setViewName("redirect:listaDeDesejos");

		}

		finaliza(mav);

		return mav;
	}

	@RequestMapping("/enviaEmailOrcamento")
	public ModelAndView enviaEmailOrcamento() {

		ModelAndView mav = new ModelAndView("redirect:listaDeDesejos");

		try {

			sendEmail(loginController.usuario.getListaDeDesejos());

			feedbacks
					.add("Mensagem enviada com sucesso. Em breve, entraremos em contato.");

		} catch (RuntimeException | MessagingException e) {

			e.printStackTrace();

			feedbacks
					.add("Erro ao enviar email. Por favor, contate o administrador do sistema.");
		}

		finaliza(mav);

		return mav;
	}

	private void sendEmail(Set<UsuarioProduto> listaDeDesejos)
			throws MessagingException {

		Properties properties = new ConnectionPropertiesBuilder().build();

		SessionBuilder sessionBuilder = new SessionBuilder(properties);

		Session session = sessionBuilder.build();

		Usuario usuario = loginController.usuario;

		ListaDeDesejosEmailBuilder listaDeDesejosEmailBuilder = new ListaDeDesejosEmailBuilder(
				listaDeDesejos);

		MessageBuilder messageBuilder = new MessageBuilder(usuario.getEmail(),
				listaDeDesejosEmailBuilder.build(), session);

		Message message = messageBuilder.build();

		Transport.send(message);
	}

	private UsuarioProduto buildUsuarioProduto(Long produtoId) {

		Produto produto = produtoDAO.findById(produtoId);

		UsuarioProduto usuarioProduto = new UsuarioProduto();

		usuarioProduto.setProduto(produto);

		usuarioProduto.setUsuario(loginController.usuario);

		usuarioProduto.setQuantidade(1);

		return usuarioProduto;
	}

}

package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.classeencanto.builder.impl.ConnectionPropertiesBuilder;
import br.com.classeencanto.builder.impl.MessageBuilder;
import br.com.classeencanto.builder.impl.SessionBuilder;
import br.com.classeencanto.model.impl.FaleConosco;

@Controller
public class FaleConoscoController {

	@Autowired
	private AdminController adminController;

	private List<String> feedbacks;

	public FaleConoscoController() {

		feedbacks = new ArrayList<>();
	}
	
	@RequestMapping("/faleConosco")
	public ModelAndView faleConosco() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("faleConosco");

		mav.addObject("isAdmin", adminController.isLogado());

		List<String> feedbacks = new ArrayList<>();

		feedbacks.addAll(this.feedbacks);

		mav.addObject("feedbacks", feedbacks);

		this.feedbacks.clear();

		return mav;
	}

	@RequestMapping("/enviaEmailFaleConosco")
	public ModelAndView enviaEmailFaleConosco(FaleConosco faleConosco) {

		ModelAndView mav = new ModelAndView("redirect:faleConosco");

		try {

			sendEmail(faleConosco);

			feedbacks.add("Mensagem enviada com sucesso. Em breve, entraremos em contato.");
			
		} catch (RuntimeException | MessagingException e) {

			e.printStackTrace();
			
			feedbacks.add("Erro ao enviar email. Por favor, contate o administrador do sistema.");
		}

		return mav;
	}

	private void sendEmail(FaleConosco faleConosco) throws MessagingException {

		Properties properties = new ConnectionPropertiesBuilder().build();

		SessionBuilder sessionBuilder = new SessionBuilder(properties);

		Session session = sessionBuilder.build();

		String mensagem = faleConosco.getMensagem() + "\n Telefone para contato: " + faleConosco.getTelefone();
		
		MessageBuilder messageBuilder = new MessageBuilder(faleConosco.getEmail(), mensagem, session);

		Message message = messageBuilder.build();

		Transport.send(message);
	}
}
package br.com.classeencanto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroDeProdutoController {
	@RequestMapping({ "/cadastroDeProduto" })
	public ModelAndView execute(String idProduto) {
		ModelAndView mav = new ModelAndView();

        // Use the view named "home" to display the data
        mav.setViewName("cadastroDeProduto");
        return mav;
	}
}
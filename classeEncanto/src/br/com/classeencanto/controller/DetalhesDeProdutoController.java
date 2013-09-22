package br.com.classeencanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetalhesDeProdutoController {
	@RequestMapping("detalhesDeProduto")
	public ModelAndView execute(String idProduto) {
		ModelAndView mav = new ModelAndView();

        // Use the view named "home" to display the data
        mav.setViewName("detalhesDeProduto");
        // Add a model object to be displayed by the view
        mav.addObject("idProduto", idProduto);
        
        List<String> itensRelacionados = new ArrayList<>();
        itensRelacionados.add("02");
        itensRelacionados.add("03");
        itensRelacionados.add("04");
        itensRelacionados.add("05");
        
		mav.addObject("itensRelacionados", itensRelacionados);

        return mav;
	}
}
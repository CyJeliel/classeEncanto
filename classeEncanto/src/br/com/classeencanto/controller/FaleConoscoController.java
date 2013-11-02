package br.com.classeencanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FaleConoscoController {
	
	@Autowired
	private AdminController adminController;
	
	@RequestMapping({ "/faleConosco" })
	public ModelAndView execute() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("faleConosco");
		
		mav.addObject("isAdmin", adminController.isLogado());
		
		return mav;
	}
}
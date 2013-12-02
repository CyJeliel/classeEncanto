package br.com.classeencanto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InstitucionalController extends FinalizaController{

	@Autowired
	private AdminController adminController;

	@RequestMapping({ "/institucional" })
	public ModelAndView execute() {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("institucional");

		finaliza(mav);

		return mav;
	}
}
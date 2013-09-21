package br.com.classeencanto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.classeencanto.dao.UsuarioDAO;
import br.com.classeencanto.entity.Usuario;

@Controller
public class AdminController {
	
	@Autowired
	private UsuarioDAO dao;

	@RequestMapping("/admin")
	public String login(//@Valid 
			Usuario usuario//, BindingResult result
			) {
		
/*		if (result.hasFieldErrors()){
			return "login";
		}
		
		if (dao.existe(usuario)){*/
			return "admin";
		/*} 
		
		return "login";*/
	}
}

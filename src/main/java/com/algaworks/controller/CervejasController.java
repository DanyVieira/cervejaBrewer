package com.algaworks.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.model.Cerveja;
import com.algaworks.model.Cliente;
import com.algaworks.model.Usuario;
import com.algaworks.repository.CervejaRepository;

@Controller
@RequestMapping("/")

public class CervejasController {
	
	@Autowired //aqui vou injetar o repository com a variavel abaixo
	private CervejaRepository cervejas;
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@RequestMapping("/cervejas/novo")
	 @GetMapping
	 public ModelAndView novo(Cerveja cerveja){ 
		ModelAndView mv = new ModelAndView("/cerveja/CadastroCerveja");
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
	//	logger.error("error"); 
		
		cervejas.findAll(); //vai listas todas as cervejas de repository
		return mv;
	 }

	@RequestMapping("/clientes/novo")
	 @GetMapping
	 public ModelAndView cliente(Cliente cliente){ 
		ModelAndView mv = new ModelAndView("/cliente/CadastroCliente");
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
		  return mv;
	 }
	
	@RequestMapping("/usuarios/novo")
	 @GetMapping
	 public ModelAndView usuario(Usuario usuario){ 
		ModelAndView mv = new ModelAndView("/usuario/CadastroUsuario");
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
		  return mv;
	 }
	
	
}

package com.algaworks.controller;

import javax.validation.Valid;

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

@Controller
@RequestMapping("/")
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	 @GetMapping
	 public ModelAndView novo(Cerveja cerveja){ 
		ModelAndView mv = new ModelAndView("/cerveja/CadastroCerveja");
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
		  return mv;
	 }

	@RequestMapping("/clientes/novo")
	 @GetMapping
	 public ModelAndView cliente(Cerveja cerveja){ 
		ModelAndView mv = new ModelAndView("/cliente/CadastroCliente");
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
		  return mv;
	 }
	
}

package com.algaworks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.model.Cliente;
import com.algaworks.model.TipoPessoa;
import com.algaworks.repository.CidadeRepository;
import com.algaworks.repository.EstadoRepository;
import com.algaworks.service.CadastroClienteService;


@Controller
@RequestMapping ("/clientes")
public class ClientesController {
	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;


	@RequestMapping("/novo")
	public ModelAndView novo(Cliente cliente){
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tipoPessoa", TipoPessoa.values());
		mv.addObject("estado", estadoRepository.findAll());
		mv.addObject("cidade", cidadeRepository.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/novo" , method = RequestMethod.POST)
	public ModelAndView cadastrar (@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes){
		
		if (result.hasErrors()){
		return novo(cliente);
				}
	    cadastroClienteService.salvar(cliente);
	    
	    return new ModelAndView("redirect:/clientes/novo");
	}

}
package com.algaworks.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.algaworks.model.Estilo;

import com.algaworks.repository.CervejaRepository;
import com.algaworks.repository.EstilosRepository;

import com.algaworks.service.CadastroEstiloService;
import com.algaworks.service.exception.NomeEstiloJaCadastradoException;


@Controller
@RequestMapping("/")

public class EstiloController {
	
	
	@Autowired //aqui vou injetar o repository com a variavel abaixo
	private CervejaRepository cervejaRepository;
	
	@Autowired
	private EstilosRepository estiloRepository;
	
	@Autowired
	private CadastroEstiloService cadastroEstiloService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@RequestMapping("/estilos/novo")
	 @GetMapping
	 public ModelAndView novo(Estilo estilo){ 
		ModelAndView mv = new ModelAndView("/estilo/CadastroEstilo");
	
		return mv;
	 }
	
@RequestMapping(value="/estilos/novo", method= RequestMethod.POST)
	public ModelAndView cadastrar (@Valid Estilo estilo,   //valid adiciona a validação ao campo
			BindingResult result,  //resultado do binding da validação 
			Model model,  //para lançar a mensagem de erro 
			RedirectAttributes attributes){ //neste caso consigo adiciionar uma mensagem em uma pagina com redirect. Pois se colocar apenas addAtribute em uma página redirect ela ira desaparecer apos o redirect

			if(result.hasErrors()){ //se ocorreu um erro no preenchimemto da variavel
				return novo(estilo);
			}
		
			try{
			cadastroEstiloService.salvar(estilo);
			}catch (NomeEstiloJaCadastradoException e) {
				result.rejectValue("nome", e.getMessage(), e.getMessage());//rejeia o valor se nome ja esta no BD
				return novo(estilo);
			}
			attributes.addFlashAttribute("mensagem", "Estilo salva com sucesso"); //agora consigo colocar uma mensagem em uma página redirect
				
			return new ModelAndView("redirect:/estilos/novo"); //redirect : se deu tudo certo quero que ele va a tela de novo cadastro ! Ou seja faz um novo get para a pagina cadastro
		
	}

	@RequestMapping (value="/estilos", method= RequestMethod.POST,    // essa aqui é a url que vou capturar que foi a mesma definida la no cadastrorapidoestilo.html
			consumes = {MediaType.APPLICATION_JSON_VALUE} ) //tipo de dado que o servidor recebe
			
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result){ //para entender o JSON pego o corpo da requisição e transformo em estilo
			System.out.println(">>>>>>>>>>>>>estilo"+estilo.getNome());
			
			
			if(result.hasErrors()){
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
			}
			
			try{
				cadastroEstiloService.salvar(estilo);
				}catch (NomeEstiloJaCadastradoException e) {
					return ResponseEntity.badRequest().body(e.getMessage());
 					
				}
			
			return ResponseEntity.badRequest().body("errooo");
	}
		
	

}

package com.algaworks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.model.Cerveja;

@Controller
@RequestMapping("/")
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	 @GetMapping
	 public String novo(Cerveja cerveja){
		
		// model.addAttribute("cerveja",new Cerveja()); //crio a variavel cerveja para chama-la la na view
		  return "cerveja/CadastroCerveja";
	 }

	@RequestMapping (value="cervejas/novo", method= RequestMethod.POST)
	public String cadastrar (@Valid Cerveja cerveja,   //valid adiciona a validação ao campo
			BindingResult result,  //resultado do binding
			Model model,  //para lançar a mensagem de erro 
			RedirectAttributes attributes){ //neste caso consigo adiciionar uma mensagem em uma pagina com redirect. Pois se colocar apenas addAtribute em uma página redirect ela ira desaparecer apos o redirect
			
		if(result.hasErrors()){ //se ocorreu um erro no preenchimemto da variavel
			//	model.addAttribute(cerveja);//pois nesse caso envio o campo que foi preenchido corretamante de volta para a view p não ter que digitar novamente
				return novo(cerveja);
		}
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso"); //agora consigo colocar uma mensagem em uma página redirect
		System.out.println("cadastrar"+cerveja.getSku());//neste caso o spring ja preencheu o objeto com o valor passado automaticamente
		return "redirect:/cervejas/novo"; //redirect : se deu tudo certo quero que ele va a tela de novo cadastro ! Ou seja faz um novo get para a pagina cadastro
		
	}
	@RequestMapping("/cervejas/cadastro")
	public String cadastro (){
		return "cerveja/cadastro-produto";
	}
	
	
}

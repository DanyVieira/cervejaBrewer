package com.algaworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.model.Cidade;
import com.algaworks.repository.CidadeRepository;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@RequestMapping("/nova")
	public String nova(){
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //caso eu receba um get com content type json caio nesse controller aqui
	public @ResponseBody List<Cidade> pesquisarPoCodigoEstado(  //com o responsebody retorno essa resposta como json
			@RequestParam(name="estado",defaultValue="-1" )Long codigoEstado){ //codigo estado sera um parametro de pesquisa
		
		try {
			Thread.sleep(500); //coloco pra dormir por 5 s para ver a bolinha girando um pouco
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cidadeRepository.findByEstadoCodigo(codigoEstado);
		
	}
}

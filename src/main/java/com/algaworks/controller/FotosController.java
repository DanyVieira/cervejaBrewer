package com.algaworks.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.dto.FotoDTO;
import com.algaworks.storage.FotoStorageRunnable;

@RestController // será um controller porem sua resposta já será um responseBody
@RequestMapping("/fotos")
public class FotosController {
	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) { // o parametro que vou receber sera o files [] do multipart e ira retornar um resultado postergado
		DeferredResult<FotoDTO> resultado = new DeferredResult<>(); //resultado postergado
		
		Thread thread = new Thread(new FotoStorageRunnable(  files, resultado)); //crio uma thread para receber as foto para melhorar a disponibilidade da app
		thread.start();
		
	
		return resultado;
	}
	
}
//DTO - responsavel por trafegar dados. Data Transfer Object
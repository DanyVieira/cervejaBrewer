package com.algaworks.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.service.exception.NomeEstiloJaCadastradoException;

@ControllerAdvice   //ela vai controlar todas as classes controller
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(NomeEstiloJaCadastradoException.class) //qual a exception que irei capturar, esse metodo trata essa excpetion lançada por qq controller
	public ResponseEntity<String> handleNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}

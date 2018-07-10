package com.algaworks.service.exception;

public class NomeEstiloJaCadastradoException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public NomeEstiloJaCadastradoException (String message){ // essa exceção é definida e lançada la na classe Cadastro estilo service 
		super(message);
	}
	

}

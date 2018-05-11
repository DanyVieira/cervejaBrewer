package com.algaworks.model;

public enum Origem {
	NACIONAL ("Nacional"),  //entre parenteses a forma que sera impresso na tela
	INTERNACIONAL ("Internacional");
	
	
		private String descricao;
	Origem (String descricao){ //construtor recebendo parametro
		this.descricao = descricao;
		
	}
	public String getDescricao() {
		return descricao;
	}
	
}	
	

package com.algaworks.model;

public enum Sabor {
	ADOCICADA ("Adocicada"), //como sera slavo no bd entre parenteses
	AMARGA("Amarga"),
	FORTE("Forte"),
	FRUTADA("Frutada"),
	SUAVE ("Suave");

	
	private String descricao;
	Sabor (String descricao){ //construtor recebendo parametro
		this.descricao = descricao;
		
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}

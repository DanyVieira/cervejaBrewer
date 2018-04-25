package com.algaworks.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cerveja {
	
//	@NotNull //aqui estou dizendo que sku não pode ser nulo tem que ser anotação do javax.validation.constraints
	@NotEmpty(message="SKU é obrigatório") //para não aceitar valor nulo 
	private String sku;
	
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	
	@Size(min=1, max=50, message="Descricão deve ter no maximo 50 caracteres")
	private String descricao;
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
		
	}



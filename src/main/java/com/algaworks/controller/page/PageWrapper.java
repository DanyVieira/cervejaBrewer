package com.algaworks.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;


public class PageWrapper<T> {
	
	private Page<T> page;
	private UriComponentsBuilder uriBuilder;

	public PageWrapper(Page<T> page , HttpServletRequest httpServletRequest) {// construtor que força passar uma página no controller
		this.page = page;
		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
	}
	
	public List<T> getConteudo(){ //método que retorna o conteúdo da página
		return page.getContent();
	}
	
	public boolean isVazia(){  //método que verifica se a lista de cerveja esta vazia 
		return page.getContent().isEmpty(); 
	}
	
	public int getAtual(){
		return page.getNumber();
	}
	
	public boolean isPrimeira(){
		return page.isFirst();
	}
	
	public boolean isUltima(){
		return page.isLast();
	}
	
	public int getTotal(){
		return page.getTotalPages();
	}
	
	public String urlPagina (int pagina){
		return uriBuilder.replaceQueryParam("page", pagina).toUriString(); //substituo parametro page da requisição pelo numero da pagina que estou passando
	}
}

package com.algaworks.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
	
	public String urlOrdenada(String propriedade){
		UriComponentsBuilder uriBuilderOrder = UriComponentsBuilder
				.fromUriString(uriBuilder.build(true).encode().toUriString()); //aqui redefino a url para que a paginação tenha a ordenação propagada
		
		String valorSort = String.format("%s,%s",propriedade,inverterDirecao(propriedade)); //aqui concateno o valor da propriedade com a inversão do sort
		return uriBuilder.replaceQueryParam("sort",  valorSort).build(true).encode().toUriString();//aqui gero a nova uri de ordenação com a propriedade
	}
	
	public String inverterDirecao(String propriedade){  //chamo esse metodo pra quando clicar pela 2 vez no icone ele ordenar na direção contrária
		String direcao = "asc";  // default é asc
		Order order = page.getSort() != null ? page.getSort().getOrderFor(propriedade):null; //se a ordem for diferente de null pego a ordem dela se não pego o null mesmo
		if (order!= null){
			direcao= Sort.Direction.ASC.equals(order.getDirection())?"desc" : "asc"; // se tem direcao e for igual a ASC  seto pra desc senão seto pra asc
		}
		return direcao;
	}
	
	public boolean descendente (String propriedade){
		return inverterDirecao(propriedade).equals("asc"); //neste caso é descendente pois invertir a posição asc
		
	}
	
	public boolean ordenada (String propriedade){
		Order order = page.getSort() != null ? page.getSort().getOrderFor(propriedade):null;//pego a ordem
		if (order == null){ // não tem ordem 
			return false;
		}
		return page.getSort().getOrderFor(propriedade) != null ?true : false; // sem ordenção verifica qual é  
	}
	
}

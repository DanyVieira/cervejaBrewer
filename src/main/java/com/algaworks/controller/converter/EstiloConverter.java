package com.algaworks.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.algaworks.model.Estilo;

public class EstiloConverter implements Converter<String, Estilo> {

	@Override
	public Estilo convert(String codigo) {
		Estilo estilo = new Estilo();
		estilo.setCodigo(Long.valueOf(codigo));
		return estilo;
		
	}

}

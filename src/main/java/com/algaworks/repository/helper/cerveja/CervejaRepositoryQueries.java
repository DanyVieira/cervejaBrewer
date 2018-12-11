package com.algaworks.repository.helper.cerveja;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public interface CervejaRepositoryQueries {  // essa interface é implementada pela classe CervejaRepositoryImpl
	
	public Page<Cerveja> filtrar (CervejaFilter filtro, Pageable pageable);  //ao filtrar retorno uma página de cerveja
	

}
 
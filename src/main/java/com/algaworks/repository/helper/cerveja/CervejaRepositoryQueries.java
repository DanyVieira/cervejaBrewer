package com.algaworks.repository.helper.cerveja;

import java.util.List;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public interface CervejaRepositoryQueries {
	
	public List<Cerveja> filtrar (CervejaFilter filtro);
	

}

package com.algaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.CervejaRepository;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private CervejaRepository cervejas;
	
	@Transactional //nesse caso abro uma transação para executar esse metodo
	public void salvar (Cerveja cerveja){
		cervejas.save(cerveja);   //aqui salvo o que esta no repository dentro do BD
	}
}

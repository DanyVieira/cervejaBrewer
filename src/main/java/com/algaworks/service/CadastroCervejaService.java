package com.algaworks.service;

import java.math.BigDecimal;

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
		
	//	BigDecimal big ;//= );
		
		//BigDecimal bigt = new BigDecimal(cerveja.getTeorString());
		//BigDecimal bigc = new BigDecimal(cerveja.getComissaoString());
		
	//	cerveja.setValor(new BigDecimal(cerveja.getValorString()));
	//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> cervejaaaaa"+ cerveja.getValor());
		//cerveja.setTeorAlcoolico(bigt);;
		//cerveja.setComissao(bigc);;
		cervejas.save(cerveja);   //aqui salvo o que esta no repository dentro do BD
	}
}

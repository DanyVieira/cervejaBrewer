package com.algaworks.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.CervejaRepository;
import com.algaworks.service.event.cerveja.CervejaSalvaEvent;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private CervejaRepository cervejas;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional //nesse caso abro uma transação para executar esse metodo
	public void salvar (Cerveja cerveja){
		
		cervejas.save(cerveja);   //aqui salvo o que esta no repository dentro do BD
		
		publisher.publishEvent(new CervejaSalvaEvent(cerveja));  //publica o evento ao salvar a cerveja, listener escuta quando a cerveja é salva para executar alguma ação
	}
}

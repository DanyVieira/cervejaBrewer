package com.algaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.model.Estilo;
import com.algaworks.repository.EstilosRepository;

@Service
public class CadastroEstiloService {
	@Autowired
	private EstilosRepository estilos;
	
	@Transactional //nesse caso abro uma transação para executar esse metodo
	public void salvar (Estilo estilo){
		estilos.save(estilo);   //aqui salvo o que esta no repository dentro do BD
	}

}

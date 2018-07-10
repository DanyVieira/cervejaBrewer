package com.algaworks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.model.Estilo;
import com.algaworks.repository.EstilosRepository;
import com.algaworks.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {
	@Autowired
	private EstilosRepository estilos;
	
	@Transactional //nesse caso abro uma transação para executar esse metodo
	public Estilo salvar (Estilo estilo){
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()){  // se o nome ja existe no BD lança a exception
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		
		return estilos.saveAndFlush(estilo);   //aqui salvo o que esta no repository dentro do BD e ainda por cima retorna o codigo do estilo
	}

}

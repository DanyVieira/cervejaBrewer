package com.algaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.model.Cliente;
import com.algaworks.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clientes;
	
	@Transactional
	public void salvar (Cliente cliente){
		clientes.save(cliente);
		
		
	}

}

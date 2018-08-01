package com.algaworks.service.event.cerveja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.storage.FotoStorage;

@Component
public class CervejaListener {

	@Autowired
	private FotoStorage fotoStorage;
	
	
	@EventListener (condition="#evento.temFoto()") //so irei salvar se houver foto
	public void cervejaSalva (CervejaSalvaEvent evento){ // esse metodo é chamado ao publicar o listener
		System.out.println("Cerveja salva com sucesso"+ evento.getCerveja().getFoto()); // o evento retorna a cerveja lembra!
		fotoStorage.salvar(evento.getCerveja().getFoto());
		
	}
}

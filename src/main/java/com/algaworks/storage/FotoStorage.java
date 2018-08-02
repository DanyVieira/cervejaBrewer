package com.algaworks.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	
	//crio uma interface para abranger varios tipos de FotoStorage Local sem precisar reimplementar o método
	public void salvarTemporariamente (MultipartFile[] files);

	public void salvar(String foto);

	public byte[] recuperar(String nome);

}

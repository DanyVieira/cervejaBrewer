package com.algaworks.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {
	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;
	private FotoStorage fotoStorage;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado, FotoStorage fotoStorage ) { //recebo a foto, retorno o resultado e chamo a classe que cri 
		this.files = files;
		this.resultado = resultado;
		this.fotoStorage = fotoStorage;
	
	}


	@Override
	public void run() { // aqui na thread é que faço a operação demorada que é salvar a foto,.
		System.out.println(">>> files: " + files[0].getSize()); //pego o tamanho do arquivo
		///salvando a foto no sistema de arquivos
		this.fotoStorage.salvarTemporariamente(files);
		
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}

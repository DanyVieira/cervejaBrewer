package com.algaworks.storage.local;


import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.storage.FotoStorage;

import net.coobird.thumbnailator.Thumbnails;


@Component
public class FotoStorageLocal implements FotoStorage{
	
	private static final Logger logger = LoggerFactory.getLogger(FotoStorageLocal.class); //tem que ser o logger do slf4j , usada pra fazer logger
	private Path local;   //onde sera salvo a foto
	private Path localTemporario;  //onde salva a foto enquanto faz o upload, ao clicar em salvar sai do temporario e vai pro local
	

	public FotoStorageLocal (){  //cpnstrutor
		this.local = FileSystems.getDefault().getPath(System.getenv("HOME"), ".brewerfotos"); // no home do usuário cria um diretorio chamado brewerfotos
		criarPastas(); //chama o metodo criar pastas
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local); //cria diretorio local
			this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp"); //dentro da pasta criada para local crio uma nova pasta chamada temp
			Files.createDirectories(this.localTemporario);  //cria diretorio temporario
			
			/// mensagens de sucesso
			if(logger.isDebugEnabled()){
				logger.debug("Pastas criadas para salvar foto com sucesso.");
				logger.debug("Pasta default: "+this.local.toAbsolutePath());
				logger.debug("Pasta temporária: "+ this.localTemporario.toAbsolutePath());
			}
			
			
		} catch (IOException e) {
			throw new RuntimeException("Erro criando pasta para salvar fotos",e);
			
		}
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] files) {
		System.out.println("salvando temporariamente>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//Thumbnails.of(this.local.resolveSibling(files).toString).size(40,68); //redimenciona a foto
	}

	@Override
	public void salvar(String foto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] recuperar(String nome) {
		
		return null;
	}
	
}

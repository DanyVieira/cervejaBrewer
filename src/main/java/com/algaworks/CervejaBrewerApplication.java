package com.algaworks;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.number.NumberStyleFormatter;

import com.algaworks.controller.FotosController;

@SpringBootApplication
public class CervejaBrewerApplication {

	public static void main(String[] args) throws IOException {
		//new File(FotosController).mkdirs();
		SpringApplication.run(CervejaBrewerApplication.class, args);
		
	
	}
	
	
	
	
}

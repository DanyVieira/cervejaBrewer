package com.algaworks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.model.Estado;


@Repository
public interface EstadoRepository extends JpaRepository <Estado,Long>{ //Long é o tipo da chave primaria da tabela em questão  
	
	public Optional<Estado> findByNomeIgnoreCase(String Nome);//encontra cerveja pelo Sku desconsiderando se letra maiuscula ou minuscula

}


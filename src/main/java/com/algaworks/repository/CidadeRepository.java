package com.algaworks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.model.Cidade;


@Repository
public interface CidadeRepository extends JpaRepository <Cidade,Long>{ //Long é o tipo da chave primaria da tabela em questão  
	
	public Optional<Cidade> findByNomeIgnoreCase(String Nome);//encontra cerveja pelo Sku desconsiderando se letra maiuscula ou minuscula

}

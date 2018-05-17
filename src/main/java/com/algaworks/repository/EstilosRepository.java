package com.algaworks.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.algaworks.model.Cerveja;
import com.algaworks.model.Estilo;



@Repository
public interface EstilosRepository extends JpaRepository <Estilo,Long>{ //Long é o tipo da chave primaria da tabela em questão  
	
	

}

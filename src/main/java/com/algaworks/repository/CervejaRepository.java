package com.algaworks.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.algaworks.model.Cerveja;



@Repository
public interface CervejaRepository extends JpaRepository <Cerveja,Long>{ //Long é o tipo da chave primaria da tabela em questão  
	
	public Optional<Cerveja> findBySkuIgnoreCase(String Sku);//encontra cerveja pelo Sku desconsiderando se letra maiuscula ou minuscula
	

}

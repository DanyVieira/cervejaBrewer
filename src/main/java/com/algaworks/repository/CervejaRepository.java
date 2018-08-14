package com.algaworks.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.algaworks.model.Cerveja;
import com.algaworks.repository.helper.cerveja.CervejasQueries;



@Repository
public interface CervejaRepository extends JpaRepository <Cerveja,Long> , CervejasQueries{ //Long é o tipo da chave primaria da tabela em questão  
	
	// uma interface extendendo outra interface(CervejasQueries) , pois na interface CervejaRepository tbm tera os metodos de cervejasQueries
	public Optional<Cerveja> findBySkuIgnoreCase(String Sku);// encontra cerveja pelo Sku desconsiderando se letra maiuscula ou minuscula
	

}

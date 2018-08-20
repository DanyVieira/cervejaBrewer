package com.algaworks.repository.helper.cerveja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public class CervejaRepositoryImpl implements CervejaRepositoryQueries { // esse nome CervejaRepositoryImpl necessariamente deve ter esse nome com Impl

	@PersistenceContext
	private EntityManager manager;  //aqui injeto o entity Manager
	
	public List<Cerveja> filtrar(CervejaFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class); //crio a criteria
		if (filtro != null){
			if (!StringUtils.isEmpty(filtro.getSku())){ // se informou um sku no filtro 
				criteria.add(Restrictions.eq("sku", filtro.getSku()));  //aqui comparo se o sku do filtro é igual ao sku do modelo
			}
		}
		return criteria.list();
	}
	

}
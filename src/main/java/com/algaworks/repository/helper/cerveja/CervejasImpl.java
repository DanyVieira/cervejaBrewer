package com.algaworks.repository.helper.cerveja;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public class CervejasImpl implements CervejasQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cerveja> filtrar(CervejaFilter filtro) {
	  @SuppressWarnings("deprecation")
	Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class); //crio a criteria
		if (filtro != null){
			if(!StringUtils.isEmpty(filtro.getSku())){
				criteria.add(Restrictions.eq("sku", filtro.getSku()));
			}
		}
		return criteria.list();
	}
	

}

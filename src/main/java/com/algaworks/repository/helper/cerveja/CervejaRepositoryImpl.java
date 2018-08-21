package com.algaworks.repository.helper.cerveja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public class CervejaRepositoryImpl implements CervejaRepositoryQueries { // esse nome CervejaRepositoryImpl necessariamente deve ter esse nome com Impl

	@PersistenceContext
	private EntityManager manager;  //aqui injeto o entity Manager
	
	public List<Cerveja> filtrar(CervejaFilter filtro) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class); //crio a criteria
		if (filtro != null){
			if (!StringUtils.isEmpty(filtro.getSku())){ // se informou um sku no filtro 
				criteria.add(Restrictions.eq("sku", filtro.getSku()));  //aqui comparo se o sku do filtro é igual ao sku do modelo
		
			}
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (isEstiloPresente(filtro)) {
				criteria.add(Restrictions.eq("estilo", filtro.getEstilo()));
			}

			if (filtro.getSabor() != null) {
				criteria.add(Restrictions.eq("sabor", filtro.getSabor()));
			}
			if (filtro.getOrigem() != null) {
				criteria.add(Restrictions.eq("origem", filtro.getOrigem()));
			}

			if (filtro.getValorDe() != null) {
				criteria.add(Restrictions.ge("valor", filtro.getValorDe())); // ge = maior ou igual
			}

			if (filtro.getValorAte() != null) {
				criteria.add(Restrictions.le("valor", filtro.getValorAte())); // le- menor ou igual
			}
			
			
			
			
			
		}
		
		
		return criteria.list();
	}
	private boolean isEstiloPresente(CervejaFilter filtro) {
		return filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
	}

}
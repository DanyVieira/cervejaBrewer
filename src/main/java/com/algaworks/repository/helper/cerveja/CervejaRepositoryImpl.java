package com.algaworks.repository.helper.cerveja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.algaworks.model.Cerveja;
import com.algaworks.repository.filter.CervejaFilter;

public class CervejaRepositoryImpl implements CervejaRepositoryQueries { // esse nome CervejaRepositoryImpl necessariamente deve ter esse nome com Impl

	@PersistenceContext
	private EntityManager manager;  //aqui injeto o entity Manager
	
	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable) {
		@SuppressWarnings("deprecation")
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class); //crio a criteria
	
		
		///////////////// cuidando da paginação//////////////////////////////
		
		int paginaAtual= pageable.getPageNumber();// a pagina sempre começa em zero
		int totalRegistrosPorPagina = pageable.getPageSize(); // setei o tamanho p 2
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina; // o registro começa por zero tbm
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);
	//////////////////////////////////////////////////////////////////////////////	
		
		adicionarFiltro(filtro, criteria);
		
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro)); // pageable tamanho da pagina (2) total sera a quantidade de páginas necessárias p a quant de registros
	}
	
	private Long total(CervejaFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
		adicionarFiltro(filtro, criteria); //agora coloco a quantidade de paginas conforme os filtros que aplico na pesquisa
		criteria.setProjection(Projections.rowCount());//retorna a quantidade de linhas da tabela!!!
		return (Long)criteria.uniqueResult();
	}
	
	private void adicionarFiltro(CervejaFilter filtro, Criteria criteria) {
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
	}
	
	private boolean isEstiloPresente(CervejaFilter filtro) {
		return filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
	}
	

}
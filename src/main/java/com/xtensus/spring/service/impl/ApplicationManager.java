package com.xtensus.spring.service.impl;

import java.util.List;

import org.hibernate.annotations.FetchProfile.FetchOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.hibernate.model.Entite;
import com.xtensus.hibernate.model.UserDetails;
import com.xtensus.qualifiers.Dao;
import com.xtensus.spring.dao.IGenericDao;
import com.xtensus.spring.service.IGenericManager;
import static com.xtensus.spring.dao.impl.QueryParameterBuilder.with;
@Service
public class ApplicationManager implements IGenericManager {

	/**
	 * @param daoe the dao to set
	 */
	@Autowired
	protected IGenericDao dao;
	private static final String USER_DETAILS_BY_ID = "userDetailsById";
	/**                              
	 * @return the dao
	 */
	public IGenericDao getDao() {
		return dao;
	}

//	/**
//	 * @param dao the dao to set
//	 */
//	public void setDao(IGenericDao dao) {
//		this.dao = dao;
//	}
//	
	@Autowired
	public void setDao(@Dao(type = Entite.class) IGenericDao dao) {
		this.dao = dao;

	}
	@Override 
	public void insert(Entite entity) throws Exception {

		dao.insert(entity);

	}
	@Override
	public void update(Entite entity) throws Exception {
		dao.update(entity);

	}
	@Override
	public void delete(Entite entity) throws Exception {
		dao.delete(entity);

	}
	@Override
	public <T extends Entite> List<T> getList(Class<T> t) throws Exception {
		return dao.getList(t);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> listeUtilisateurParId(int userId) {
				
		return (List<UserDetails>) dao.getListWithNamedQuery(USER_DETAILS_BY_ID,with("idu", userId).parameters());
	}

}

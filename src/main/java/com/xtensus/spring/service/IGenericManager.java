package com.xtensus.spring.service;

import java.util.List;

import com.xtensus.hibernate.model.Entite;
import com.xtensus.hibernate.model.UserDetails;

public interface IGenericManager {

	public void insert(Entite entity) throws Exception;

	public void update(Entite entity) throws Exception;

	public void delete(Entite entity) throws Exception;

	public <T extends Entite> List<T> getList(Class<T> t) throws Exception;
	public List<UserDetails> listeUtilisateurParId(int userId);
}

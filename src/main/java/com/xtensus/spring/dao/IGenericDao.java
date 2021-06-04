package com.xtensus.spring.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.xtensus.hibernate.model.Entite;

@Transactional(propagation = Propagation.REQUIRED)
public interface IGenericDao {
	
	//============================================================================================
	//============================================================================================
	//*******************  Liste des Requetes standards de Hibernation CRUD  *********************
	//============================================================================================
	//============================================================================================
	
	public void insert(Entite entity) throws HibernateException;

	public void update(Entite entity) throws HibernateException;

	public void delete(Entite entity) throws HibernateException;

	public <T extends Entite> List<T> getList(final Class<T> t) throws HibernateException;
	
	//============================================================================================
	//============================================================================================

	
	//============================================================================================
	//============================================================================================
	//*******************  Liste des Méthodes pour l'utilisation de query.hbm.xml*****************
	//============================================================================================
	//============================================================================================
	
	//1- Méthode pour exécuter une requête qui retourne une liste des données
	//1.1- Requête sans paramètres
	public List<? extends Entite> getListWithNamedQuery(final String namedQueryName) throws HibernateException;
	//1.2- Requête avec des paramètres
	public List<? extends Entite> getListWithNamedQuery(final String namedQueryName,final Map<String, Object> parameters) throws HibernateException;

	
	//2- Méthode pour exécuter une requête de mise à jour sur des données
	//2.1- Requête sans paramètres
	public void deleteWithNamedQuery(final String namedQueryName) throws HibernateException;
	//2.2- Requête avec des paramètres
	public void deleteWithNamedQuery(final String namedQueryName, final Map<String, Object> parameters)throws HibernateException;
	
	
	//3- Méthode pour exécuter une requête de suppression des données
	//3.1- Requête sans paramètres
	public void updateWithNamedQuery(final String namedQueryName) throws HibernateException;
	//3.2- Requête avec des paramètres
	public void updateWithNamedQuery(final String namedQueryName, final Map<String, Object> parameters)throws HibernateException;
	
	//============================================================================================
	//============================================================================================
	
}

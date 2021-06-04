package com.xtensus.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.xtensus.hibernate.model.Entite;
import com.xtensus.qualifiers.Dao;
import com.xtensus.spring.dao.IGenericDao;

@Dao(type = Entite.class)
public class AbstractGenericDao implements IGenericDao {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessiionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessiionFactory the sessiionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Entite entity) throws HibernateException {
		getSession().persist(entity);
	}

	@Override
	public void update(Entite entity) throws HibernateException {
		getSession().saveOrUpdate(entity);

	}

	@Override
	public void delete(Entite entity) throws HibernateException {
		getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Entite> List<T> getList(Class<T> classe) throws HibernateException {
		Criteria criteria = getSession().createCriteria(classe);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entite> getListWithNamedQuery(String namedQueryName) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Entite> getListWithNamedQuery(String namedQueryName, Map<String, Object> parameters)
			throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		return query.list();
	}

	@Override
	public void deleteWithNamedQuery(String namedQueryName) throws HibernateException {
		Query query = getSession().createQuery(namedQueryName);
		query.executeUpdate();
	}

	@Override
	public void deleteWithNamedQuery(String namedQueryName, Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		query.executeUpdate();
	}

	@Override
	public void updateWithNamedQuery(String namedQueryName) throws HibernateException {
		Query query = getSession().createQuery(namedQueryName);
		query.executeUpdate();

	}

	@Override
	public void updateWithNamedQuery(String namedQueryName, Map<String, Object> parameters) throws HibernateException {
		Query query = getSession().getNamedQuery(namedQueryName);
		query.setProperties(parameters);
		query.executeUpdate();
	}

}

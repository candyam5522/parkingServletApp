package com.aimtech.parkingservlet.dao;


import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aimtech.parkingservlet.model.Lenoxproperty;
import com.aimtech.parkingservlet.util.HibernateUtil;

public class LenoxpropertyDao {
    final static Logger logger = LogManager.getLogger(LenoxpropertyDao.class);
    
	public void saveLenoxproperty(Lenoxproperty lenoxproperty){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx= session.beginTransaction();
			session.save(lenoxproperty);
			tx.commit();
		} catch (Exception ex){
			if(tx !=null){
				tx.rollback();
			}
			throw ex;
		}
	}
	
	public Lenoxproperty getLenoxproperty(Lenoxproperty lenoxproperty){
		Lenoxproperty foundLenoxproperty = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx= session.beginTransaction();
			String hql = "FROM Lenoxproperty L WHERE L.streetNumber = :streetNumber "
					+ "AND L.streetName = :streetName AND L.city = :city AND L.state = :state AND L.zipCode = :zipCode";
			Query query = session.createQuery(hql);
			query.setParameter("streetNumber",lenoxproperty.getStreetNumber());
			query.setParameter("streetName",lenoxproperty.getStreetName());
			query.setParameter("city",lenoxproperty.getCity());
			query.setParameter("state",lenoxproperty.getState());
			query.setParameter("zipCode",lenoxproperty.getZipCode());
			logger.info("********streetNumber: {}; streetName: {}; city: {}; state: {}; "
					+ "zipCode: {};********", 
					query.getParameterValue("streetNumber"), query.getParameterValue("streetName"),query.getParameterValue("city"), 
					query.getParameterValue("state"), query.getParameterValue("zipCode"));			
			List result = query.list();
			
	        Iterator iterator = result.iterator();
	        while(iterator.hasNext()){
	        	foundLenoxproperty = (Lenoxproperty) iterator.next();
	        	logger.info("********Found matching record in LenoxpropertyDao********");
	        }
	        tx.commit();
	        return foundLenoxproperty;
		} catch (Exception ex){
			if(tx !=null){
				tx.rollback();
			}
			throw ex;
		}
	}	
}

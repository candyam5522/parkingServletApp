package com.aimtech.parkingservlet.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aimtech.parkingservlet.model.Lenoxproperty;
import com.aimtech.parkingservlet.util.HibernateUtil;

public class LenoxpropertyDao {
	public void postLenoxproperty(Lenoxproperty lenoxproperty){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(lenoxproperty);
		tx.commit();
	}
}

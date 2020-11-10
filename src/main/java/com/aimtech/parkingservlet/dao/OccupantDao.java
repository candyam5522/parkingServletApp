package com.aimtech.parkingservlet.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aimtech.parkingservlet.model.Occupant;
import com.aimtech.parkingservlet.util.HibernateUtil;

public class OccupantDao {
	public void saveOccupant(Occupant occupant){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(occupant);
			tx.commit();
		}catch (Exception ex){
			if(tx != null){
				tx.rollback();
			}
			throw ex;
		}
	}
}

package com.aimtech.parkingservlet.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aimtech.parkingservlet.model.Occupant;
import com.aimtech.parkingservlet.util.HibernateUtil;

public class OccupantDao {
	public void postOccupant(Occupant occupant){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(occupant);
		tx.commit();
	}
}

package com.aimtech.parkingservlet.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.aimtech.parkingservlet.model.Test;
import com.aimtech.parkingservlet.util.HibernateUtil;

public class TestDao {

	public List<Test> getTests(){
		ArrayList tests = new ArrayList<Test>();
		return tests;
	}
	
	public void postTest(){
		Test test = new Test();
		test.setFirstname("Miao");
		test.setLastname("Ai");		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(test);
		tx.commit();
		session.close();
	}
}

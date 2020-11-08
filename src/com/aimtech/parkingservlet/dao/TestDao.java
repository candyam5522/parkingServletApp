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
		test.setIdtest(9);
		test.setFirstname("Miao"+test.getIdtest());
		test.setLastname("Ai"+test.getIdtest());		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(test);
		tx.commit();
		session.close();
	}
}

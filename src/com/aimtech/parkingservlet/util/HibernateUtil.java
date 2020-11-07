package com.aimtech.parkingservlet.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aimtech.parkingservlet.model.Test;

public class HibernateUtil {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Test.class);
		SessionFactory sf = cfg.buildSessionFactory();
}

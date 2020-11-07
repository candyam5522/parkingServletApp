package com.aimtech.parkingservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aimtech.parkingservlet.model.Test;



/**
 * Servlet implementation class SubmitInformation
 */
@WebServlet("/SubmitInformation")
public class SubmitInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitInformation() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Test test = new Test();
		test.setIdtest(5);
		test.setFirstname("Miao"+test.getIdtest());
		test.setLastname("Ai"+test.getIdtest());
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Test.class);
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(test);
		tx.commit();
		session.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

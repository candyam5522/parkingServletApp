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
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.aimtech.parkingservlet.dao.TestDao;
import com.aimtech.parkingservlet.model.Test;



/**
 * Servlet implementation class SubmitInformation
 */
@WebServlet("/SubmitInformation")
public class SubmitInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestDao testDao;
	
    public SubmitInformation() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		testDao = new TestDao();
		testDao.postTest();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

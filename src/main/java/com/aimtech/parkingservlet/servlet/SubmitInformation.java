package com.aimtech.parkingservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aimtech.parkingservlet.dao.TestDao;



/**
 * Servlet implementation class SubmitInformation
 */
@WebServlet("/submitInformation")
public class SubmitInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestDao testDao;

    final static Logger logger = LogManager.getLogger(SubmitInformation.class);
    
    public SubmitInformation() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String occupantFirstName = request.getParameter("occupantFirstName");
		String occupantLastName = request.getParameter("occupantLastName");
		logger.info("This is a log4j message {} {}", occupantFirstName, occupantLastName);
		testDao = new TestDao();
		testDao.postTest(occupantFirstName,occupantLastName);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

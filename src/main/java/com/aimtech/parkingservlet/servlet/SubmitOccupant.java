package com.aimtech.parkingservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aimtech.parkingservlet.dao.LenoxpropertyDao;
import com.aimtech.parkingservlet.dao.OccupantDao;
import com.aimtech.parkingservlet.dao.TestDao;
import com.aimtech.parkingservlet.model.Lenoxproperty;
import com.aimtech.parkingservlet.model.Occupant;



/**
 * Servlet implementation class SubmitOccupant
 */
@WebServlet("/submitOccupant")
public class SubmitOccupant extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OccupantDao occupantDao;
    private LenoxpropertyDao lenoxpropertyDao;
    
    final static Logger logger = LogManager.getLogger(SubmitOccupant.class);
    
    public SubmitOccupant() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String streetNumber = request.getParameter("streetNumber");
		String streetName = request.getParameter("streetName");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		
		logger.info("********streetNumber: {}; streetName: {}; city: {}; state: {}; "
				+ "zipCode: {};********", 
				streetNumber, streetName,city, state, zipCode);
		
		Lenoxproperty lenoxproperty =new Lenoxproperty();
		lenoxproperty.setStreetNumber(streetNumber);
		lenoxproperty.setStreetName(streetName);
		lenoxproperty.setCity(city);
		lenoxproperty.setState(state);
		lenoxproperty.setZipCode(zipCode);
		
		lenoxpropertyDao = new LenoxpropertyDao();
		Lenoxproperty foundLenoxproperty = lenoxpropertyDao.getLenoxproperty(lenoxproperty);
		if (foundLenoxproperty == null){
			lenoxpropertyDao.saveLenoxproperty(lenoxproperty);
		} else {
			lenoxproperty.setIdlenoxproperty(foundLenoxproperty.getIdlenoxproperty());
		}
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String emergencyContactFirstName = request.getParameter("emergencyContactFirstName");
		String emergencyContactLastName = request.getParameter("emergencyContactLastName");
		String emergencyContactPhone = request.getParameter("emergencyContactPhone");
		String type = request.getParameter("Type");
		logger.info("********firstName: {}; lastName: {}; email: {}; phone: {}; "
				+ "emergencyContactFirstName: {}; emergencyContactLastName: {}; emergencyContactPhone: {}; type: {}********", 
				firstName, lastName,email, phone, emergencyContactFirstName,emergencyContactLastName,emergencyContactPhone,type);
		
		Occupant occupant = new Occupant();
		occupant.setFirstName(firstName);
		occupant.setLastName(lastName);
		occupant.setEmail(email);
		occupant.setPhone(phone);
		occupant.setEmergencyContactFirstName(emergencyContactFirstName);
		occupant.setEmergencyContactLastName(emergencyContactLastName);
		occupant.setEmergencyContactPhone(emergencyContactPhone);
		if(type.equals("owner")){
			occupant.setOwner(true);
		}else if(type.equals("tenant")){
			occupant.setTenant(true);
		}
		occupant.setLenoxproperty(lenoxproperty);
		occupant.setCurrent(true);

		occupantDao = new OccupantDao();
		occupantDao.saveOccupant(occupant);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

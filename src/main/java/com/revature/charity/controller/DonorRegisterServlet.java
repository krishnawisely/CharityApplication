package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;

/**
 * Servlet implementation class DonorRegisterServlet
 */
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isLoggedIn = false;
		DonorService service = new DonorServiceImpl();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		LocalDate dateOfBirth = LocalDate.parse(dob);
		Donor donor = new Donor();
		donor.setName(name);
		donor.setEmail(email);
		donor.setPassword(password);
		donor.setDateOfBirth(dateOfBirth);
		donor.setGender(gender);
		
		isLoggedIn = service.donorRegister(donor);
		
			PrintWriter out = response.getWriter();
			String json = "{\"err_msg\""+":"+"\""+isLoggedIn+"\"}";
			out.write(json);
		
	}

}

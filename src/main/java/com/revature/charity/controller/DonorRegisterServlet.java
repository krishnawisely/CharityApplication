package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.model.Donor;

/**
 * Servlet implementation class DonorRegisterServlet
 */
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String json = DonorRegisterController.donorRegister(donor);
			PrintWriter out = response.getWriter();
			out.write(json);	
	}

}

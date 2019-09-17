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
		String name = "user";
		String email = "useremail2@gmail.com";
		String password = "mypass";
		String gender = "male";
		LocalDate dateOfBirth = LocalDate.parse("2019-09-10");
		Donor donor = new Donor();
		donor.setName(name);
		donor.setEmail(email);
		donor.setPassword(password);
		donor.setDateOfBirth(dateOfBirth);
		donor.setGender(gender);
		
		isLoggedIn = service.donorRegister(donor);
		
			PrintWriter out = response.getWriter();
			String json = "{\"Err_msg:\""+"\""+isLoggedIn+"\"}";
			out.write(json);
		
	}

}

package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.charity.model.Donor;
import com.revature.charity.service.DonorService;
import com.revature.charity.service.DonorServiceImpl;

/**
 * Servlet implementation class DonorServlet
 */
public class DonorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorService service = new DonorServiceImpl();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		String email = "krishna@gmail.com";
		String password = "mypass";
		donor.setEmail(email);
		donor.setPassword(password);
		donorObj = service.donorSignin(donor);
		
		Gson gson = new Gson();
		String json = gson.toJson(donorObj);
		
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
}

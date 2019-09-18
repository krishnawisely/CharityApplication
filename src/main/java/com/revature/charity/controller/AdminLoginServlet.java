package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Admin admin = new Admin();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		admin.setEmail(email);
		admin.setPassword(password);
		String json = AdminLoginController.adminLogin(admin);
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}

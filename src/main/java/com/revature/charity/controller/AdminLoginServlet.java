package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.charity.model.Admin;
import com.revature.charity.service.AdminService;
import com.revature.charity.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = new AdminServiceImpl();
		Admin admin = new Admin();
		Admin adminObj = new Admin();
		String email = "admin@gmail.com";
		String password = "mypass";
		admin.setEmail(email);
		admin.setPassword(password);
		adminObj = service.adminLoginService(admin);
		
		Gson gson = new Gson();
		String json = gson.toJson(adminObj);
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}

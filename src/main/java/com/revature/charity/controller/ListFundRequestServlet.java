package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.charity.model.FundRequest;
import com.revature.charity.service.FundRequestService;
import com.revature.charity.service.FundRequestServiceImpl;

/**
 * Servlet implementation class ListFundRequestServlet
 */
public class ListFundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FundRequestService service = new FundRequestServiceImpl();
		String requestType = request.getParameter("requestType");
		List<FundRequest> list = service.listFundRequest(requestType);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}

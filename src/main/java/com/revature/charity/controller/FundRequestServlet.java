package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.model.FundRequest;
import com.revature.charity.service.FundRequestService;
import com.revature.charity.service.FundRequestServiceImpl;

/**
 * Servlet implementation class FundRequestServlet
 */
public class FundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean isStatus = false;
		FundRequestService service = new FundRequestServiceImpl();
		FundRequest fundRequest = new FundRequest();
		fundRequest.setAdminId(1);
		fundRequest.setRequestType("OTHERS");
		fundRequest.setDescription("others fund");
		fundRequest.setAmount(100000D);
		LocalDate expireDate = LocalDate.parse("2019-09-27");
		fundRequest.setExpireDate(expireDate);
		isStatus = service.fundRequestService(fundRequest);

		String json = "{\"isStatus:\"" + "\"" + isStatus + "\"}";
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}

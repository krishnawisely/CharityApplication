package com.revature.charity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.charity.model.Transaction;
import com.revature.charity.service.TransactionService;
import com.revature.charity.service.TransactionServiceImpl;

/**
 * Servlet implementation class TransactionServlet
 */
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean status = false;
		TransactionService service = new TransactionServiceImpl();
		Transaction transactionObj = new Transaction();
		String donorId = request.getParameter("id");
		Integer id = Integer.parseInt(donorId);
		
		String fundRequestId = request.getParameter("fundRequestId");
		Integer fundId = Integer.parseInt(fundRequestId);
		
		String amount = request.getParameter("amount");
		Double requestAmount = Double.parseDouble(amount);
		
		transactionObj.setDonorId(id);
		transactionObj.setfundRequestId(fundId);
		transactionObj.setAmount(requestAmount);
		status = service.transaction(transactionObj);
		
		String json = "{\"status:\"" + "\"" + status +"\"}";
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}

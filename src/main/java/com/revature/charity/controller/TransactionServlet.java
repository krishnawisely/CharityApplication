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
		Integer donorId = 1;
		Integer fundRequestId = 2;
		Double amount = 5000D;
		transactionObj.setDonorId(donorId);
		transactionObj.setfundRequestId(fundRequestId);
		transactionObj.setAmount(amount);
		status = service.transaction(transactionObj);
		
		String json = "{status:" + status +"}";
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}

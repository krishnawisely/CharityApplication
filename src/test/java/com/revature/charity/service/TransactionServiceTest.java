package com.revature.charity.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.charity.model.Transaction;

public class TransactionServiceTest {
	@Test
	public void transactionServiceTest()
	{
		Boolean isStatus = null;
		TransactionService service = new TransactionServiceImpl();
		Transaction transactionObj = new Transaction();
		transactionObj.setDonorId(1);
		transactionObj.setfundRequestId(3);
		transactionObj.setAmount(5000D);
		isStatus = service.transaction(transactionObj);
		assertEquals(true, isStatus);
	}
}

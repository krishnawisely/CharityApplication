package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Transaction;

public class TransactionTest {
	@Test
	public void transactionTest()
	{
		Transaction transaction = new Transaction();
		TransactionDAO transactionDAO = new TransactionImpl();
		Boolean isStatus = false;
		try {
			transaction.setfundRequestId(2);
			transaction.setDonorId(1);
			transaction.setAmount(1000D);
			isStatus = transactionDAO.transaction(transaction);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
}

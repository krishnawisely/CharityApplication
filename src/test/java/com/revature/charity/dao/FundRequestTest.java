package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;

public class FundRequestTest {
	@Test
	public void fundRequestTest()
	{
		FundRequestDAO fundRequest = new FundRequestImpl();
		FundRequest request = new FundRequest();
		Boolean isStatus = null;
		try {
			request.setAdminId(1);
			request.setRequestType("EDUCATION");
			request.setDescription("education fund");
			request.setAmount(25000D);
			LocalDate expireDate = LocalDate.parse("2019-09-25");
			request.setExpireDate(expireDate);
			fundRequest.fundRequest(request);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
}

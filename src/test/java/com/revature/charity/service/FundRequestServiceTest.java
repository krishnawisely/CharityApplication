package com.revature.charity.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.model.FundRequest;

public class FundRequestServiceTest {
	@Test
	public void fundRequestTest()
	{
		Boolean isStatus = null;
		FundRequestService fundService = new FundRequestServiceImpl();
		FundRequest request = new FundRequest();
		request.setAdminId(1);
		request.setRequestType("MEDICAL");
		request.setDescription("medical fund");
		request.setAmount(40000D);
		LocalDate expireDate = LocalDate.parse("2019-09-30");
		request.setExpireDate(expireDate);
		isStatus = fundService.fundRequestService(request);
		assertEquals(true, isStatus);
	}
}

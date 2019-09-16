package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.model.FundRequest;

public class ListFundRequestTest {
	@Test
	public void listFundRequestTest() {
		FundRequestService requestService = new FundRequestServiceImpl();
		List<FundRequest> lists = null;
		lists = requestService.listFundRequest("EDUCATION");
		assertNotNull(lists);
		for(FundRequest list  : lists)
		{
			System.out.println(list);
		}
	}
}

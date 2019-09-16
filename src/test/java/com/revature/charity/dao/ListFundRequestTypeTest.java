package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;

public class ListFundRequestTypeTest {
	@Test
	public void listRequest()
	{
		FundRequestDAO fundRequest = new FundRequestImpl();
		try {
			List<FundRequest> lists = fundRequest.findByRquestType("FOOD");
			for(FundRequest list : lists)
			{
				System.out.println(list);
			}
			assertNotNull(lists);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
}

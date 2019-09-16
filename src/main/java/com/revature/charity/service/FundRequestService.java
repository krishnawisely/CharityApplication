package com.revature.charity.service;

import java.util.List;

import com.revature.charity.model.FundRequest;

public interface FundRequestService {
	public Boolean fundRequestService(FundRequest request);
	public List<FundRequest> listFundRequest(String requestType);
}

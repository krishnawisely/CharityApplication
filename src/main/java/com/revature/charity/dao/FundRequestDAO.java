package com.revature.charity.dao;

import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;

public interface FundRequestDAO {
	public List<FundRequest> findByRquestType(String requestType) throws DBException;
	public Boolean fundRequest(FundRequest request) throws DBException;
}

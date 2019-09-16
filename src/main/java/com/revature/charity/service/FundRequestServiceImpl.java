package com.revature.charity.service;

import java.util.List;

import javax.xml.bind.ValidationException;

import com.revature.charity.dao.FundRequestDAO;
import com.revature.charity.dao.FundRequestImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.FundRequest;
import com.revature.charity.validator.FundRequestValidator;

public class FundRequestServiceImpl implements FundRequestService {
	/** Fund request service **/
	public Boolean fundRequestService(FundRequest request)
	{
		FundRequestDAO requestDao = new FundRequestImpl();
		Logger logger = new Logger();
		Boolean isStatus = null;
		try {
			FundRequestValidator.fundRequest(request);
			isStatus = requestDao.fundRequest(request);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		} catch (ValidationException e) {
			logger.debug(e.getMessage());
		}
		return isStatus;
	}
	/** List fund request **/
	public List<FundRequest> listFundRequest(String requestType)
	{
		FundRequestDAO requestDao = new FundRequestImpl();
		Logger logger = new Logger();
		List<FundRequest> list = null;
		try {
			list = requestDao.findByRquestType(requestType);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		}
		return list;
	}
}

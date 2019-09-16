package com.revature.charity.validator;

import javax.xml.bind.ValidationException;

import com.revature.charity.model.FundRequest;

public class FundRequestValidator {
	public static void fundRequest(FundRequest request) throws ValidationException
	{
		String requestType = request.getRequestType();
		String descrition = request.getDescription();
		
		if(requestType == null || "".equals(requestType))
		{
			throw new ValidationException("Invalid request type");
		}
		if(descrition == null || "".equals(descrition))
		{
			throw new ValidationException("Invalid description");
		}
	}
}

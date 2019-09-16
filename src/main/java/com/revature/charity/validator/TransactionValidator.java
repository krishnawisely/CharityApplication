package com.revature.charity.validator;

import com.revature.charity.model.Transaction;

import sun.security.validator.ValidatorException;

public class TransactionValidator {
	/** Transaction validator **/
	public static void loginValidator(Transaction transaction) throws ValidatorException
	{
		Double amount = transaction.getAmount();
		
		if(amount < 0)
		{
			throw new ValidatorException("Invalid amount");
		}
	}
}

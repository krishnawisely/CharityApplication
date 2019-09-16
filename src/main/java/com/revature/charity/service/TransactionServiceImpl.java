package com.revature.charity.service;

import com.revature.charity.dao.TransactionDAO;
import com.revature.charity.dao.TransactionImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.Transaction;
import com.revature.charity.validator.TransactionValidator;

import sun.security.validator.ValidatorException;

public class TransactionServiceImpl implements TransactionService {
	public Boolean transaction(Transaction transactionObj)
	{
		Logger logger = new Logger();
		TransactionDAO transaction = new TransactionImpl();
		Boolean isStatus = false;
		try {
			TransactionValidator.loginValidator(transactionObj);
			isStatus = transaction.transaction(transactionObj);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		} catch (ValidatorException e) {
			logger.debug(e.getMessage());
		}
		return isStatus;
	}
}

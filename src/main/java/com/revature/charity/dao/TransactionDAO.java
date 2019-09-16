package com.revature.charity.dao;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Transaction;

public interface TransactionDAO {
	public Boolean transaction(Transaction transaction) throws DBException;
}

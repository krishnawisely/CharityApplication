package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Transaction;
import com.revature.charity.util.ConnectionUtil;

public class TransactionImpl implements TransactionDAO {
	public Boolean transaction(Transaction transaction) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean isStatus = false;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "INSERT INTO transaction(donor_id,fund_request_id,amount) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sqlStmt);
			
			Integer donorId = transaction.getDonorId();
			Integer fundRequestId = transaction.getfundRequestId();
			Double amount = transaction.getAmount();
			
			
			pstmt.setInt(1, donorId);
			pstmt.setInt(2, fundRequestId);
			pstmt.setDouble(3, amount);
			if(pstmt.executeUpdate() == 1)
			{
				isStatus = true;
			}
		} catch(SQLException e) {
			throw new DBException("Unable to transaction",e);
		}
		return isStatus;
	}
}

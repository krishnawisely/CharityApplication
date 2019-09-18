package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.ConnectionUtil;

public class FundRequestImpl implements FundRequestDAO {
	/** Fund request **/
	public Boolean fundRequest(FundRequest request) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean isStatus = false;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "INSERT INTO fund_request(admin_id,request_type,description,amount,expire_date) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sqlStmt);
			
			Integer adminId = request.getAdminId();
			String requestType = request.getRequestType();
			String description = request.getDescription();
			Double amount = request.getAmount();
			LocalDate expireLocalDate = request.getExpireDate();
			Date expireDate = Date.valueOf(expireLocalDate);
			
			pstmt.setInt(1, adminId);
			pstmt.setString(2, requestType);
			pstmt.setString(3, description);
			pstmt.setDouble(4, amount);
			pstmt.setDate(5, expireDate);
			if(pstmt.executeUpdate() == 1)
			{
				isStatus = true;
			}
		} catch(SQLException e){
			throw new DBException("Unable to request",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return isStatus;
	}
	
	/** toRow **/
	public FundRequest toRow(ResultSet rs)
	{
		Logger logger = new Logger();
		String requestType;
		FundRequest request = null;
		try {
			Integer fundRequestId = rs.getInt("id");
			requestType = rs.getString("request_type");
			String description = rs.getString("description");
			Double neededAmount = rs.getDouble("needed_amount");
			Date expireDate = rs.getDate("expire_date");
			
			request = new FundRequest();
			request.setId(fundRequestId);
			request.setRequestType(requestType);
			request.setDescription(description);
			request.setAmount(neededAmount);
			request.setExpireDate(expireDate.toLocalDate());
		} catch (SQLException e) {
			logger.debug(e.getMessage());
		}
		return request;
	}
	
	/** List fund request **/
	public List<FundRequest> findByRquestType(String requestType) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FundRequest> list = null;

		list = new ArrayList<FundRequest>();
		try {
			conn = ConnectionUtil.getConnection();
			
//			String sqlStmt = "SELECT id,request_type,description,expire_date,"
//					+ "("
//					+ "SELECT IF((SUM(amount) <= fr.amount),(fr.amount - SUM(amount)),0) FROM transaction WHERE fund_request_id = fr.id GROUP BY fund_request_id HAVING SUM(amount) <= fr.amount"
//					+ ") AS needed_amount"
//					+ " FROM fund_request fr WHERE request_type = ? AND amount > (SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = fr.id)";
			String sqlStmt = "SELECT id,request_type,description,expire_date,(amount - (SELECT IFNULL(SUM(amount),0)FROM transaction WHERE fund_request_id = fr.id)) AS needed_amount FROM fund_request fr WHERE request_type = ? AND amount > (SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = fr.id)";
			System.out.println(sqlStmt);
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, requestType);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				list.add(toRow(rs));
			}
			
		} catch(SQLException e){
			e.printStackTrace();
			throw new DBException("Unable to list request",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, rs);
		}
		return list;
	}
}

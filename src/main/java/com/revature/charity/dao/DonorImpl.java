package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.ConnectionUtil;

public class DonorImpl implements DonorDAO{
	/** Donor Login **/
	public Donor donorLogin(Donor donor) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Donor donorObj = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "SELECT id,name,email FROM donor WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, donor.getEmail());
			pstmt.setString(2, donor.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				donorObj = new Donor();
				donorObj.setId(rs.getInt("id"));
				donorObj.setName(rs.getString("name"));
				donorObj.setEmail(rs.getString("email"));
			}
		} catch(SQLException e)
		{
			throw new DBException("Unable to login",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return donorObj;
	}
	/** Donor register **/
	public Boolean donorRegister(Donor donor) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "INSERT INTO donor(name,email,password,date_of_birth,gender) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sqlStmt);
			/** Convert local date into date **/
			Date dateOfBirth = Date.valueOf(donor.getDateOfBirth());
			
			pstmt.setString(1, donor.getName());
			pstmt.setString(2, donor.getEmail());
			pstmt.setString(3, donor.getPassword());
			pstmt.setDate(4, dateOfBirth);
			pstmt.setString(5, donor.getGender());
			/** Check user login **/
			int rows = pstmt.executeUpdate();
			if(rows == 1)
			{
				result = true;
			}
		} catch(SQLException e) {
			throw new DBException("Unable to register",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return result;
	}
	/** Check email is exist **/
	public Donor isEmailExist(String email) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Donor donorObj = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "SELECT name,email FROM donor WHERE email = ?";
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				donorObj = new Donor();
				donorObj.setName(rs.getString("name"));
				donorObj.setEmail(rs.getString("email"));
			}
		} catch(SQLException e)
		{
			throw new DBException("Unable to login",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return donorObj;
	}
}

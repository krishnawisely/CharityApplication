package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Admin;
import com.revature.charity.util.ConnectionUtil;

public class AdminImpl implements AdminDAO {
	/** Admin Login **/
	public Admin adminLogin(Admin admin) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin adminObj = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "SELECT id,name,email FROM admin WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, admin.getEmail());
			pstmt.setString(2, admin.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				adminObj = new Admin();
				adminObj.setId(rs.getInt("id"));
				adminObj.setName(rs.getString("name"));
				adminObj.setEmail(rs.getString("email"));
			}
		} catch(SQLException e)
		{
			throw new DBException("Unable to login",e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return adminObj;
	}
	
}

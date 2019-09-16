package com.revature.charity.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.charity.logger.Logger;

public class Close {
	public Close(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		Logger logger = new Logger();
		try {
			if(conn != null)
				conn.close();
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
		}
	}
}

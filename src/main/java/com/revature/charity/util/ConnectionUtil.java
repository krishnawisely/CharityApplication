package com.revature.charity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.charity.logger.Logger;

public class ConnectionUtil {
	
	/** Get connection **/
		public static Connection getConnection()
		{
			Logger logger = new Logger();
			final String driverClass = "com.mysql.jdbc.Driver";
			final String url = "jdbc:mysql://localhost:3306/charity_app";
			Connection conn = null;
			try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url);
			}
			catch(ClassNotFoundException e)
			{
				logger.debug(e.getMessage());
			}
			catch(SQLException e)
			{
				logger.debug(e.getMessage());
			}
			return conn;
		}
		
}

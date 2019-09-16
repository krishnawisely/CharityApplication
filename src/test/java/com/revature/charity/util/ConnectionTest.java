package com.revature.charity.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

public class ConnectionTest {
	@Test
	public void connectionTest()
	{
		Connection conn = ConnectionUtil.getConnection();
		assertNotNull(conn);
	}
}

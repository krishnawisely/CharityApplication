package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.Admin;

public class adminLoginTest {
	@Test
	public void adminLogin()
	{
		AdminDAO adminDAO = new AdminImpl();
		Admin admin = new Admin();
		Admin adminObj = new Admin();
		admin.setEmail("admin@gmail.com");
		admin.setPassword("mypass");
		Logger logger = new Logger();
		try {
			adminObj = adminDAO.adminLogin(admin);
			assertNotNull(adminObj);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		}
	}
}

package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.model.Admin;

public class AdminLoginTest {
	@Test
	public void adminLoginTest()
	{
		AdminService serivce = new AdminServiceImpl();
		Admin admin = new Admin();
		Admin adminObj = new Admin();
		admin.setEmail("admin@gmail.com");
		admin.setPassword("mypass");
		adminObj = serivce.adminLoginService(admin);
		assertNotNull(adminObj);
	}
}

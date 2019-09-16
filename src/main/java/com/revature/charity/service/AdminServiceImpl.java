package com.revature.charity.service;

import com.revature.charity.dao.AdminDAO;
import com.revature.charity.dao.AdminImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.Admin;

public class AdminServiceImpl implements AdminService {
	public Admin adminLoginService(Admin admin)
	{
		AdminDAO adminDao = new AdminImpl();
		Admin adminObj = new Admin();
		Logger logger = new Logger();
		try {
			adminObj = adminDao.adminLogin(admin);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		}
		return adminObj;
	}
}

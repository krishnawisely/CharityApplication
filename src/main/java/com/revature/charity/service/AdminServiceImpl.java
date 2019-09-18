package com.revature.charity.service;

import com.revature.charity.dao.AdminDAO;
import com.revature.charity.dao.AdminImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Admin;
import com.revature.charity.validator.AdminValidator;

import sun.security.validator.ValidatorException;

public class AdminServiceImpl implements AdminService {
	public Admin adminLoginService(Admin admin) throws ServiceException
	{
		AdminDAO adminDao = new AdminImpl();
		Admin adminObj = new Admin();
		
		try {
			AdminValidator.loginValidator(admin);
			adminObj = adminDao.adminLogin(admin);
			if(adminObj == null)
			{
				throw new ServiceException("Invalid username and password");
			}
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} 
		catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		return adminObj;
	}
}

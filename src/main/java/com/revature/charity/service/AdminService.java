package com.revature.charity.service;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Admin;

public interface AdminService {
	public Admin adminLoginService(Admin admin) throws ServiceException;
}

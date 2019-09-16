package com.revature.charity.dao;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Admin;

public interface AdminDAO {
	public Admin adminLogin(Admin admin) throws DBException;
}

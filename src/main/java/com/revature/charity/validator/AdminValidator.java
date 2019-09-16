package com.revature.charity.validator;

import com.revature.charity.model.Admin;

import sun.security.validator.ValidatorException;

public class AdminValidator {
	/** Login validator **/
	public static void loginValidator(Admin admin) throws ValidatorException
	{
		String email = admin.getEmail();
		String password = admin.getPassword();
		
		if(email == null || "".equals(email))
		{
			throw new ValidatorException("Invalid email");
		}
		if(password == null || "".equals(password))
		{
			throw new ValidatorException("Invalid password");
		}
	}
}

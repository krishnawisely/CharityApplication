package com.revature.charity.validator;

import com.revature.charity.dao.DonorDAO;
import com.revature.charity.dao.DonorImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;

import sun.security.validator.ValidatorException;

public class DonorValidator {
	/** Login validator **/
	public static void loginValidator(Donor donor) throws ValidatorException
	{
		String email = donor.getEmail();
		String password = donor.getPassword();
		
		if(email == null || "".equals(email))
		{
			throw new ValidatorException("Invalid email");
		}
		if(password == null || "".equals(password))
		{
			throw new ValidatorException("Invalid password");
		}
	}
	/** Register validator **/
	public static void registerValidator(Donor donor) throws ValidatorException
	{
		String email = donor.getEmail();
		String password = donor.getPassword();
		
		DonorDAO donorDao = new DonorImpl();
		Donor donorObj = new Donor();
		try {
			donorObj = donorDao.isEmailExist(email);
			if(donorObj != null)
			{
				throw new ValidatorException("Email is already exist");
			}
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
		
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

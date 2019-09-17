package com.revature.charity.service;

import com.revature.charity.dao.DonorDAO;
import com.revature.charity.dao.DonorImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.Donor;
import com.revature.charity.validator.DonorValidator;

import sun.security.validator.ValidatorException;

public class DonorServiceImpl implements DonorService{
	/** Donor login service **/
	public Donor donorSignin(Donor donor)
	{
		DonorDAO donorDao = new DonorImpl();
		Donor donorObj = null;
		Logger logger = new Logger();
		try {
			DonorValidator.loginValidator(donor);
			donorObj = donorDao.donorLogin(donor);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		} catch (ValidatorException e) {
			logger.debug(e.getMessage());
		}
		return donorObj;
	}
	/** Donor register service 
	 * @throws DBException **/
	public Boolean donorRegister(Donor donor) 
	{
		Boolean isLoggedIn = false;
		DonorDAO donorDao = new DonorImpl();
		Logger logger = new Logger();
		try {
			DonorValidator.registerValidator(donor);
			isLoggedIn = donorDao.donorRegister(donor);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		} catch (ValidatorException e) {
			logger.debug(e.getMessage());
		}
		return isLoggedIn;
	}
}

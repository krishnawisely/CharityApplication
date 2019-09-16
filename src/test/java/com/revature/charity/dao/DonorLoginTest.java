package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.logger.Logger;
import com.revature.charity.model.Donor;

public class DonorLoginTest {
	@Test
	public void donorLoginTest()
	{
		DonorDAO donorDAO = new DonorImpl();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		donor.setEmail("krishna@gmail.com");
		donor.setPassword("mypass");
		Logger logger = new Logger();
		try {
			donorObj = donorDAO.donorLogin(donor);
			assertNotNull(donorObj);
		} catch (DBException e) {
			logger.debug(e.getMessage());
		}
	}
}

package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;

public class IsEmailExistTest {
	@Test
	public void isEmailExist()
	{
		DonorDAO donor = new DonorImpl();
		Donor donorObj = new Donor();
		try {
			donorObj = donor.isEmailExist("krishna@gmail.com");
			assertNotNull(donorObj);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}
}

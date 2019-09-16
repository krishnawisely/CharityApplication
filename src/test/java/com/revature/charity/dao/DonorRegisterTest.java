package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;

public class DonorRegisterTest {
	
	@Test
	public void donorRegisterTest()
	{
		Boolean isLoggedIn = null;
		DonorDAO donorDAO = new DonorImpl();
		Donor donor = new Donor();
		donor.setName("test");
		donor.setEmail("test@gmail.com");
		donor.setPassword("mypass");
		LocalDate dateOfBirth = LocalDate.parse("1997-06-05");
		donor.setDateOfBirth(dateOfBirth);
		donor.setGender("male");
		try {
			isLoggedIn = donorDAO.donorRegister(donor);
			assertEquals(true, isLoggedIn);
		} catch (DBException e) {
			System.out.println(e.getMessage());
		}
	}

}

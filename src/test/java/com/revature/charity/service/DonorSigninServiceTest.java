package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.model.Donor;

public class DonorSigninServiceTest {
	@Test
	public void donorSigninServiceTest()
	{
		DonorService service = new DonorServiceImpl();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		donor.setEmail("krishna@gmail.com");
		donor.setPassword("mypass");
		donorObj = service.donorSignin(donor);
		assertNotNull(donorObj);
	}
}
